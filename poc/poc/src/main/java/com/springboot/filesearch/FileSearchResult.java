package com.springboot.filesearch;

import java.nio.file.Path;
import java.util.List;

public class FileSearchResult {
	private Path filePath;
	private List<String> wordsToSearch;
	private boolean searchResult;
	
	public FileSearchResult(Path filePath,  List<String> wordsToSearch, boolean searchResult) {
		super();
		this.filePath = filePath;
		this.wordsToSearch = wordsToSearch;
		this.searchResult = searchResult;
	}

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}

	
	public boolean isSearchResult() {
		return searchResult;
	}

	public void setSearchResult(boolean searchResult) {
		this.searchResult = searchResult;
	}

	public List<String> getWordsToSearch() {
		return wordsToSearch;
	}

	public void setWordsToSearch(List<String> wordsToSearch) {
		this.wordsToSearch = wordsToSearch;
	}
	
	
}
