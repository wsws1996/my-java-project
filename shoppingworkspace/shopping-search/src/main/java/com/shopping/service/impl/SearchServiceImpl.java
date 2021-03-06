package com.shopping.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.SearchDao;
import com.shopping.pojo.SearchResult;
import com.shopping.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult search(String queryString, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery(queryString);
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		query.set("df", "item_keywords");
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");

		SearchResult searchResult = searchDao.search(query);

		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount / rows;
		if (pageCount % rows > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurPage(page);
		return searchResult;
	}

}
