package org.wang.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.wang.utils.LuceneUtils;

public class TestQuery {

	public static void main(String[] args) throws IOException, ParseException {
		// Query query=new TermQuery(new Term("author", "乔治·奥威尔"));
		// String fields[]={"author"};
		// QueryParser queryParser=new
		// MultiFieldQueryParser(LuceneUtils.getMatchVersion(), fields,
		// LuceneUtils.getAnalyzer());
		// Query query=queryParser.parse("乔治·奥威尔");
		// Query query=new MatchAllDocsQuery();

//		Query query=NumericRangeQuery.newIntRange("id", 1, 10, true, true);
		
//		Query query=new WildcardQuery(new Term("title", "luce*"));
//		Query query=new FuzzyQuery(new Term("author", "自由的旗"),3);
		
//		PhraseQuery query=new PhraseQuery();
//
//		query.add(new Term("title", "语"));
//		
//		query.add(new Term("title", "java"));
//		query.setSlop(666666);
		
		BooleanQuery query=new BooleanQuery();
		Query query1=NumericRangeQuery.newIntRange("id", 1, 10, true, true);
		Query query2=NumericRangeQuery.newIntRange("id", 5, 15, true, true);
		
		query.add(query1, Occur.MUST);
		query.add(query2, Occur.SHOULD);
		
		testQuery(query);
	}

	public static void testQuery(Query query) throws IOException {
		IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();

		TopDocs topDocs = indexSearcher.search(query, 100);
		System.out.println("总记录数："+topDocs.totalHits);
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			Document document = indexSearcher.doc(scoreDoc.doc);
			System.out.println(document.get("id"));
			System.out.println(document.get("title"));
			System.out.println(document.get("content"));
			System.out.println(document.get("author"));
			System.out.println(document.get("link"));
		}
	}
}
