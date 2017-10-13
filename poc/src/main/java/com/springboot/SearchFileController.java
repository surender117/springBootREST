package com.springboot;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.WordSearchInFilesService;

@RestController
public class SearchFileController {

	@RequestMapping("/searchFile")
	public String searchFile(@RequestParam(value = "str") String str) {

		String fileName = null;
		System.out.println("given input is ::::" + str);
		Path start = Paths.get("E:/books");
		int maxDepth = 5;
		try (Stream<Path> stream = Files.find(start, maxDepth,
				(path, attr) -> String.valueOf(path).contains(str))) {
			fileName = stream.sorted().map(String::valueOf).filter((path) -> {
				return String.valueOf(path).contains(str);
			}).collect(Collectors.joining());
			System.out.println("fileName(s)---->: " + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	@RequestMapping("/wordSearchInFiles")
	public String WordSearchInFiles(@RequestParam(value = "word") String word) {

		String[] wordsToSearch = word.split(",");

		WordSearchInFilesService test = new WordSearchInFilesService();
		
		List<String> results = test.listDirectory("c:\\Backup-31-July-2017", 0,
				wordsToSearch);

		String output = "";
		for (String result : results) {
			output += result + "\n";
		}

		return output;
	}

}
