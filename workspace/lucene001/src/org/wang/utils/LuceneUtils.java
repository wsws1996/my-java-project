package org.wang.utils;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class LuceneUtils {

	private static Directory directory = null;

	private static IndexWriterConfig config = null;

	private static Version matchVersion = null;

	

	

	private static Analyzer analyzer = null;
	static {
		try {
			directory = FSDirectory.open(new File(Contants.INDEXURL));
			matchVersion = Version.LUCENE_44;

			analyzer = new StandardAnalyzer(matchVersion);
			config = new IndexWriterConfig(matchVersion, analyzer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @description
	 * @author wang
	 * @version
	 * @createDate 2016年5月1日
	 * @return 返回用于操作索引的对象
	 * @throws IOException
	 */
	public static IndexWriter getIndexWriter() throws IOException {
		IndexWriter indexWriter = new IndexWriter(directory, config);
		return indexWriter;
	}

	/**
	 * 
	 * @description
	 * @author wang
	 * @version
	 * @createDate 2016年5月1日
	 * @return 返回用于读取索引的对象
	 * @throws IOException
	 */
	public static IndexSearcher getIndexSearcher() throws IOException {
		IndexReader indexReader = DirectoryReader.open(directory);

		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		return indexSearcher;
	}
	/**
	 * 
	 * @description 
	 * @author wang
	 * @version 
	 * @createDate 2016年5月2日
	 * @return lucene当前使用的版本信息
 	 */
	public static Version getMatchVersion() {
		return matchVersion;
	}
	
	/**
	 * 
	 * @description 
	 * @author wang
	 * @version 
	 * @createDate 2016年5月2日
	 * @return lucene使用的分词器
	 */
	public static Analyzer getAnalyzer() {
		return analyzer;
	}
}
