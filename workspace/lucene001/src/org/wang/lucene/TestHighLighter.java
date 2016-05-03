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
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.wang.bean.Article;
import org.wang.utils.LuceneUtils;

public class TestHighLighter {
	public static void main(String[] args) throws ParseException, IOException, InvalidTokenOffsetsException {
		
		 String fields[]={"title"};
		 String keywords="very";
				 QueryParser queryParser=new
				 MultiFieldQueryParser(LuceneUtils.getMatchVersion(), fields,
				 LuceneUtils.getAnalyzer());
				 Query query=queryParser.parse(keywords);
		IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();

		TopDocs topDocs = indexSearcher.search(query, 100);
		
		Formatter formatter=new SimpleHTMLFormatter("<font color='red'>", "</font>");
		
		Scorer fragmentScorer=new QueryScorer(query);
		
		Highlighter highlighter=new Highlighter(formatter, fragmentScorer);
		
		System.out.println("总记录数："+topDocs.totalHits);
		Article article=null;
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			Document document = indexSearcher.doc(scoreDoc.doc);

			String title=document.get("title");
			
			System.out.println("高亮之前：title："+title);
			String content=document.get("content");
			System.out.println("高亮之前：content："+content);
			
			String hightitle=highlighter.getBestFragment(LuceneUtils.getAnalyzer(), "title", title);
			String highcontent=highlighter.getBestFragment(LuceneUtils.getAnalyzer(), "content", content);
			System.out.println("高亮之后-----------------------");
			System.out.println("高亮之后：title："+hightitle);
			System.out.println("高亮之后：content："+highcontent);
			article=new Article();
			if (hightitle==null) {
				article.setTitle(title);
			}else {
				article.setTitle(hightitle);
			}
			
			if (highcontent==null) {
				article.setContent(content);
			}else {
				article.setContent(highcontent);
			}
			
			System.out.println("最终结果：title:"+article.getTitle());
			System.out.println("最终结果：content:"+article.getContent());
			
		}
	}
}
