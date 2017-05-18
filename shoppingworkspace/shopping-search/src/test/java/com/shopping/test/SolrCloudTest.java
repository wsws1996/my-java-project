package com.shopping.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloudTest {

	@Test
	public void testAddDocument() throws Exception {
		String zkHost = "192.168.33.10:2181,192.168.33.10:2182,192.168.33.10:2183";
		CloudSolrServer solrServer = new CloudSolrServer(zkHost);
		solrServer.setDefaultCollection("collection2");

		SolrInputDocument document = new SolrInputDocument();

		document.addField("id", "test001");
		document.addField("item_title", "测试商品");

		solrServer.add(document);

		solrServer.commit();
	}

	@Test
	public void deleteDocument() throws SolrServerException, IOException {
		String zkHost = "192.168.33.10:2181,192.168.33.10:2182,192.168.33.10:2183";
		CloudSolrServer solrServer = new CloudSolrServer(zkHost);
		solrServer.setDefaultCollection("collection2");

		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}

}
