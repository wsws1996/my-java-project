package com.shopping.service;

import com.shopping.pojo.SearchResult;

public interface SearchService {
	public SearchResult search(String queryString, int page);
}
