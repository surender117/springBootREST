package com.springboot.filesearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FileScanner {
	private static List<Path> filePathList = new ArrayList<Path>();

	public static void main(String[] args) throws IOException {
		//String path = "E:\\javafiles";
		String path = "E:\\javafiles";
		listFiles(path);
		System.out.println("Num of Files " + filePathList.size());
		List<String> words = Arrays.asList("Exception","try");

		long startTime = System.currentTimeMillis();
		searchFiles(words);
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " milliseconds");
	}

	private static void searchFiles(List<String> words) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		List<Future<FileSearchResult>> resultList = new ArrayList<>();
		for (int i = 0; i < filePathList.size(); i++) {
		Future<FileSearchResult> result = executor.submit(new FileContentSearch(new FileSearchResult(filePathList.get(i), words, false)));
		resultList.add(result);
		}
		int fountCt=0;
		int notFoundCnt=0;
		for (Future<FileSearchResult> future : resultList) {
			
			try {
				if(future.get().isSearchResult()){
					fountCt++;
				}else{
					notFoundCnt++;
				}
				
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Found Count " + fountCt + " Not Found Count " + notFoundCnt);
		executor.shutdown();
	}

	private static void listFiles(String path) throws IOException {
		Files.walk(Paths.get(path)).forEach(filePath -> filePathList.add(filePath));
	}

}
