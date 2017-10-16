package com.springboot.filesearch;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class FileContentSearch implements Callable<FileSearchResult>
{
 
    private FileSearchResult fileSearchResult;
 
    public FileContentSearch(FileSearchResult fileSearchResult) {
        this.fileSearchResult = fileSearchResult;
    }
 
    @Override
    public FileSearchResult call() throws Exception {
    	   	
    	searchWords(fileSearchResult);
    
        return fileSearchResult;
    }
    
    
	public void searchWords(FileSearchResult fileSearchResult) {
		
		Scanner fileToScan = null;
		try {
			fileToScan = new Scanner(fileSearchResult.getFilePath());
		} catch (Exception e) {
		}
        if(fileToScan!=null){
		while (fileToScan.hasNextLine()) {
			String line = fileToScan.nextLine();
			for (String wordToSearch : fileSearchResult.getWordsToSearch()) {
				if (line.contains(wordToSearch)) {
					fileSearchResult.setSearchResult(true); 
					return;
				}
			}
		}
		fileToScan.close();
        }
		
	}

}