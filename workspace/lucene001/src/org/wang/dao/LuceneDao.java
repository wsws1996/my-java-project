package org.wang.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.wang.bean.Article;
import org.wang.utils.ArticleUtils;
import org.wang.utils.LuceneUtils;

/**
 * 使用lucene操作索引库
 * 
 * @author wang
 * 
 */
public class LuceneDao {
	public void addIndex(Article article) throws IOException {
		IndexWriter indexWriter = LuceneUtils.getIndexWriter();
		Document doc = ArticleUtils.articleToDocument(article);
		indexWriter.addDocument(doc);
		indexWriter.close();
	}

	public void delIndex(String fieldName,String fieldValue) throws IOException {
		IndexWriter indexWriter=LuceneUtils.getIndexWriter();
		Term term=new Term(fieldName, fieldValue);
		
		indexWriter.deleteDocuments(term);
		
		indexWriter.close();
	}
	/**
	 * 
	 * @description 先删除符合条件的记录，再创建一个修改后的记录 
	 * @author wang
	 * @version 
	 * @createDate 2016年5月2日
	 * @param fieldName
	 * @param fieldValue
	 * @param article
	 * @throws IOException
	 */
	public void updateIndex(String fieldName,String fieldValue,Article article) throws IOException {
		IndexWriter indexWriter=LuceneUtils.getIndexWriter();
		Term term=new Term(fieldName, fieldValue);
		Document doc=ArticleUtils.articleToDocument(article);
		indexWriter.updateDocument(term, doc);
		indexWriter.close();
	}

	public List<Article> findIndex(String keywords,int start,int rows) throws Exception {
		IndexSearcher indexSearcher=LuceneUtils.getIndexSearcher();
		String fields[]={"title","content"};
		QueryParser queryParser=new MultiFieldQueryParser(LuceneUtils.getMatchVersion(), fields, LuceneUtils.getAnalyzer());
		Query query=queryParser.parse(keywords);
		TopDocs topDocs= indexSearcher.search(query, start+rows);
		System.out.println("总记录数："+topDocs.totalHits);
		ScoreDoc scoreDocs[] =topDocs.scoreDocs;
		
		Article article=null;
		
		List<Article> articleList=new ArrayList<Article>();
		int endResult=Math.min(scoreDocs.length, start+rows);
		for (int i = start; i < endResult; i++) {
			int docID=scoreDocs[i].doc;
			System.out.println("编号："+docID);
			article=new Article();
			Document document=indexSearcher.doc(docID);
			article.setId(Integer.parseInt(document.get("id")));
			article.setTitle(document.get("title"));
			article.setContent(document.get("content"));
			article.setLink(document.get("link"));
			article.setAuthor(document.get("author"));
			
			articleList.add(article);
			
		}
		return articleList;
	}
}
