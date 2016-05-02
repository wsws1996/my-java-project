package org.wang.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.RAMDirectory;
import org.wang.utils.Contants;
import org.wang.utils.LuceneUtils;

public class TestSort {
	public static void main(String[] args) throws IOException, ParseException {
		Directory directory1 = FSDirectory.open(new File(Contants.INDEXURL));

		IOContext ioContext = new IOContext();

		Directory directory = new RAMDirectory(directory1, ioContext);

		IndexReader indexReader = DirectoryReader.open(directory);

		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		String fields[] = { "title" };
		QueryParser queryParser = new MultiFieldQueryParser(
				LuceneUtils.getMatchVersion(), fields,
				LuceneUtils.getAnalyzer());
		Query query = queryParser.parse("故事");
	
		Sort sort=new Sort();
		
		SortField field=new SortField("id", Type.INT,true);
		
		sort.setSort(field);
		
		TopDocs topDocs = indexSearcher.search(query, 100, sort);
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			Document document=indexSearcher.doc(scoreDoc.doc);
			System.out.println(document.get("id"));
		}
	}
}
