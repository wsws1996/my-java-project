package org.wang.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.index.MergePolicy;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;
import org.wang.utils.Contants;
import org.wang.utils.LuceneUtils;

public class TestOptimise {
	public void testOptimise1() throws IOException {
		Directory directory=FSDirectory.open(new File(Contants.INDEXURL));
		IndexWriterConfig config=new IndexWriterConfig(LuceneUtils.getMatchVersion(), LuceneUtils.getAnalyzer());
		
		LogDocMergePolicy mergePolicy=new LogDocMergePolicy();
		mergePolicy.setMergeFactor(6);
		
		config.setMergePolicy(mergePolicy);
		
		IndexWriter indexWriter=new IndexWriter(directory, config);
	}
	
	@Test
	public void testOptimise2() throws IOException, ParseException {
		Directory directory1=FSDirectory.open(new File(Contants.INDEXURL));
		
		IOContext ioContext=new IOContext();
		
		Directory directory=new RAMDirectory(directory1,ioContext);
		
		IndexReader indexReader=DirectoryReader.open(directory);
		
		IndexSearcher indexSearcher=new IndexSearcher(indexReader);
		
		String fields[]={"title"};
		QueryParser queryParser=new MultiFieldQueryParser(LuceneUtils.getMatchVersion(), fields, LuceneUtils.getAnalyzer());
		Query query=queryParser.parse("故事");
		TopDocs topDocs= indexSearcher.search(query,100);
		System.out.println(topDocs.totalHits);
	}
	
}
