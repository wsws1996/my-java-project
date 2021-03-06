package com.shopping.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {
	@Test
	public void addDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.33.10:8080/solr");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test001");
		document.addField("item_title", "测试商品1");
		document.addField("item_price", 12345);
		solrServer.add(document);
		solrServer.commit();
	}

	@Test
	public void deleteDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.33.10:8080/solr");
		// solrServer.deleteById("test001");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
