package com.springboot;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.WordSearchInFilesService;

@RestController
public class SearchFileController {
	
	private static final Logger log = LoggerFactory.getLogger(WordSearchInFilesService.class);
	
	@Autowired
	private WordSearchInFilesService wordSearchInFilesService;

	public static final String DIR_PATH = "E:\\files";
	public static final int MAX_DEPTH = 5;

	
	//@RequestMapping("/wordSearchInFiles")
	@RequestMapping(value ="/wordSearchInFiles", method = RequestMethod.GET, produces = "application/json")
	public String WordSearchInFiles(@RequestParam(value = "word") String word) throws IOException {
		
		String output = "";
		log.info("Input "+word);
		if (word.contains("-")){
			List<Path> filePaths = wordSearchInFilesService.searchWordsInPath(DIR_PATH, word.split("-"));
			for (Path path : filePaths) {
				output += path;
			}
			if (filePaths.size()==0 || filePaths==null){			
				throw new RuntimeException("Exception:: key word is not present in any of the files111 ");
			}
		}else{
			String str[] = new String[1];
			str[0]=word;
			List<Path> filePaths1 = wordSearchInFilesService.searchWordsInPath(DIR_PATH, str);			
			for (Path path : filePaths1) {
				output += path;
			}
			if (filePaths1.size()==0 || filePaths1==null){			
				throw new RuntimeException("Exception:: key word is not present in any of the files ");
			}
		}		
		
		return output;
	}

}
