package com.springboot.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WordSearchInFilesService {

	// String [] wordsToSearch = {"where","word2","word3"};
	String[] wordsToSearch = null;
	List<String> results = null;

	public List<String> listDirectory(String dirPath, int level, String[] word) {
		results = new ArrayList<String>();

		listDirectories(dirPath, level, word);
		return results;
	}

	public void listDirectories(String dirPath, int level, String[] word) {
		wordsToSearch = word;

		File dir = new File(dirPath);
		File[] firstLevelFiles = dir.listFiles();
		if (firstLevelFiles != null && firstLevelFiles.length > 0) {
			for (File aFile : firstLevelFiles) {
				if (aFile.isDirectory()) {
					listDirectories(aFile.getAbsolutePath(), level + 1,
							wordsToSearch);
				} else {
					// new Thread(){
					// public void run(){
					Scanner fileToScan = null;
					// System.out.println(fileObj.getAbsolutePath());
					try {
						fileToScan = new Scanner(aFile);
					} catch (Exception e) {
						// e.printStackTrace();

					}

					while (fileToScan.hasNextLine()) {
						String line = fileToScan.nextLine();
						for (String wordToSearch : wordsToSearch) {
							if (line.indexOf(" " + wordToSearch) != -1
									|| line.indexOf(" " + wordToSearch + " ") != -1) {
								System.out.println(wordToSearch
										+ " - Word Exists in File - "
										+ aFile.getAbsolutePath() + "\n");
								results.add(wordToSearch
										+ " - Word Exists in File - "
										+ aFile.getAbsolutePath() + "\n");

							}
						}
					}
					fileToScan.close();
					// }
					// }.start();;

				}
			}
		}
		System.out.println("results" + results.size());

	}

}
