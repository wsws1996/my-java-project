package org.wang.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.wang.utils.LuceneUtils;

public class TestScore {
	
	public static void main(String[] args) throws IOException, ParseException {
		testSearcher("故事");
	}
	public static void testSearcher(String keywords) throws IOException, ParseException {
		IndexSearcher indexSearcher=LuceneUtils.getIndexSearcher();
		String fields[]={"title"};
		QueryParser queryParser=new MultiFieldQueryParser(LuceneUtils.getMatchVersion(), fields, LuceneUtils.getAnalyzer());
		Query query=queryParser.parse(keywords);
		TopDocs topDocs= indexSearcher.search(query, 100);
		System.out.println("总记录数："+topDocs.totalHits);
		ScoreDoc scoreDocs[] =topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			
			Document document=indexSearcher.doc(scoreDoc.doc);
			System.out.println("id："+document.get("id")+"，得分："+scoreDoc.score);
		}
	}
}
