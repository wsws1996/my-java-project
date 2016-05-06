package org.wang.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.wang.bean.Article;

public class SolrJ {

	@Test
	public void addIndex() throws SolrServerException, IOException {
		String urlString = "http://localhost:8983/solr";
		SolrServer solr = new HttpSolrServer(urlString);

		 SolrInputDocument document=new
		 SolrInputDocument();
		
		 document.addField("id", "9527");
		
		 document.addField("name", "李和故");
		 Map<String, String> map=new HashMap<String,String>();

		 map.put("er", "qw");
		 map.put("yu", "op");
		 
		 document.addField("xxxxx_ss", map);
		
		
		 solr.add(document);
		
//		List<Article> list=new ArrayList<Article>();
//		
//		Article article = null;
//		
//		for (int i = 0; i <=25; i++) {
//			article=new Article();
//			
//			article.setId(i);
//
//			article.setTitle("高富帅");
//
//			article.setContent("白富美");
//			
//			article.setName("刘二去");
//
//			article.setPrice(19);
//			
//			list.add(article);
//		}
//
//		
//		solr.addBeans(list);
		

//		solr.addBean(article);

		solr.commit();
	}

	@Test
	public void del() throws SolrServerException, IOException {
		String urlString = "http://localhost:8983/solr";
		SolrServer solr = new HttpSolrServer(urlString);

		solr.deleteById("999");

		solr.commit();
	}
	@Test
	public void testFind() throws SolrServerException {
		String urlString = "http://localhost:8983/solr";
		SolrServer solr = new HttpSolrServer(urlString);

		SolrQuery solrParams = new SolrQuery();

		solrParams.setQuery("description:记录");
		
		solrParams.setStart(0);
		
		solrParams.setRows(10);
		
		solrParams.setHighlight(true);
		
		solrParams.setHighlightSimplePre("<font color='red'>");
		solrParams.setHighlightSimplePost("</font>");
		
		solrParams.setParam("hl.fl", "description");
		QueryResponse queryResponse = solr.query(solrParams);
		
		SolrDocumentList documentList= queryResponse.getResults();
		
		Map<String, Map<String, List<String>>> maplist=queryResponse.getHighlighting();
		
		for (SolrDocument solrDocument : documentList) {
			Object id=solrDocument.get("id");
//			Object name=solrDocument.get("name");
//			Object description=solrDocument.get("description");
//			
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(description);
			Map<String, List<String>> fieldMap=maplist.get(id);
			List<String> stringList=fieldMap.get("description");
			System.out.println(stringList);
		}
	}
}
