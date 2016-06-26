package org.wang.elec.utils;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Configuration {

	// 索引库的目录位置
	private static Directory directory;
	// 分词器
	private static Analyzer analyzer;

	static {
		try {
			File dir = new File(".." + File.separator + "developerFiles"
					+ File.separator + "indexDir");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			directory = FSDirectory.open(dir);
			/** 词库分词 */
			analyzer = new IKAnalyzer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Directory getDirectory() {
		return directory;
	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

}
