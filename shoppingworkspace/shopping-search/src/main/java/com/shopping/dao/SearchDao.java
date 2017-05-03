package com.shopping.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.shopping.pojo.SearchResult;

public interface SearchDao {
	SearchResult search(SolrQuery query) throws Exception;
}
