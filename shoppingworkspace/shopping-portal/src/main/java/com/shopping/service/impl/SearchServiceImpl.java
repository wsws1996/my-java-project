package com.shopping.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.pojo.SearchResult;
import com.shopping.pojo.ShoppingResult;
import com.shopping.service.SearchService;
import com.shopping.utils.HttpClientUtil;

@Service
public class SearchServiceImpl implements SearchService {

	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;

	@Override
	public SearchResult search(String queryString, int page) {

		Map<String, String> param = new HashMap<>();
		param.put("q", queryString);
		param.put("page", page + "");
		try {
			String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
			ShoppingResult shoppingResult = ShoppingResult.formatToPojo(json, SearchResult.class);
			if (shoppingResult.getStatus() == 200) {
				SearchResult result = (SearchResult) shoppingResult.getData();
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
