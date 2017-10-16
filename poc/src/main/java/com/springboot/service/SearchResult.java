package com.springboot.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SearchResult {
	private List<Path> results;
	
	public SearchResult(){
		results=new ArrayList<Path>();
	}

	public List<Path> getResults() {
		return results;
	}

	public void setResults(List<Path> results) {
		this.results = results;
	}

	

}
