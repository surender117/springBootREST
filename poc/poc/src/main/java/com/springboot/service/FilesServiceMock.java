package com.springboot.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FilesServiceMock {
	
	private String[] wordsToSearch = null;
	private List<String> results = null;
	public static final String DIR_PATH = "c:\\Backup-31-July-2017";
	public static final int MAX_DEPTH = 5;

	public List<String> listDirectory(String dirPath, int level, String[] word) {
		results = new ArrayList<String>();
		listDirectories(dirPath, level, word);
		return results;
	}

	public void listDirectories(String dirPath, int level, String[] word) {
		wordsToSearch = word;
		Scanner fileToScan = null;

		File dir = new File(dirPath);
		File[] firstLevelFiles = dir.listFiles();
		if (firstLevelFiles != null && firstLevelFiles.length > 0) {
			for (File aFile : firstLevelFiles) {
				if (aFile.isDirectory()) {
					listDirectories(aFile.getAbsolutePath(), level + 1,
							wordsToSearch);
				} else {
					try {
						fileToScan = new Scanner(aFile);
					} catch (Exception e) {
						e.printStackTrace();
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
				}
			}
		}
		System.out.println("results" + results.size());

	}

}
