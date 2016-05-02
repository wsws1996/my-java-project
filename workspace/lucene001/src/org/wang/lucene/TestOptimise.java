package org.wang.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogDocMergePolicy;
import org.apache.lucene.index.MergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
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
	
	
}
