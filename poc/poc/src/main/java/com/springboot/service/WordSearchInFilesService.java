package com.springboot.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class WordSearchInFilesService {	
	private static final Logger log = LoggerFactory.getLogger(WordSearchInFilesService.class);	
	public  List<Path> searchWordsInPath(String dirPath,String[] wordsToSearch) throws IOException {		
		log.info("Num Of Searching words "+wordsToSearch.length);
		List<Path> filesFound=new ArrayList<Path>();
		List<Path> filePaths = new ArrayList<Path>();
		long startTime = System.currentTimeMillis();
		
		if(wordsToSearch.length>0){
		Files.walk(Paths.get(dirPath)).forEach(filePath -> filePaths.add(filePath));
		log.info("WordSearchInFilesService"+filePaths.size() );
						
		boolean found=false;
		for (int i = 0; i < filePaths.size(); i++) {
			found=searchWordsInFile(filePaths.get(i),wordsToSearch);
						
			if(found){
			filesFound.add(filePaths.get(i));
			}
		}			
		} else {
			
			throw new RuntimeException("Exception:: please provide words to search");			
		}
		long endTime = System.currentTimeMillis();
		log.info("It took " + (endTime - startTime) + " milliseconds");
		return filesFound;
	}	  
	  public boolean searchWordsInFile(Path path,String[] wordsToSearch) {
			boolean found=false;
			Scanner fileToScan = null;
			try {
				fileToScan = new Scanner(path);
			} catch (Exception e) {
				
				log.info(e.getMessage());
			}
	        if(fileToScan!=null){
			while (fileToScan.hasNextLine()) {
				String line = fileToScan.nextLine();
				for (String wordToSearch : wordsToSearch) {
					if (line.contains(wordToSearch)) {
						
						found=true;
						return found;
					}					
				}							
			}			
			fileToScan.close();
	        }
			return found;
			
		}
}
