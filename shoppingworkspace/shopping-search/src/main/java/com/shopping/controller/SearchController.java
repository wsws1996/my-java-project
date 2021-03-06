package com.shopping.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.SearchResult;
import com.shopping.pojo.ShoppingResult;
import com.shopping.service.SearchService;
import com.shopping.utils.ExceptionUtil;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(value ="/query", method = RequestMethod.GET)
	@ResponseBody
	public ShoppingResult search(@RequestParam("q") String queryString, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "60") Integer rows) {
		if (StringUtils.isBlank(queryString)) {
			return ShoppingResult.build(400, "查询条件不能为空");
		}
		SearchResult searchResult = null;
		try {
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			searchResult = searchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return ShoppingResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ShoppingResult.ok(searchResult);

	}

}
