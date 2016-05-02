package org.wang.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class TestLucene {

	@Test
	public void testCreateIndex() throws IOException {
		Directory directory = FSDirectory.open(new File("indexDir/"));
		Version matchVersion = Version.LUCENE_44;

		Analyzer analyzer = new StandardAnalyzer(matchVersion);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				matchVersion, analyzer);

		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

		Document doc = new Document();

		IndexableField field = new IntField("id", 1, Store.YES);

		IndexableField title = new StringField("title", "我是中国人java", Store.YES);

		IndexableField content = new TextField("content",
				"我是中国人，中国是社会主义所有制国java家，实行人民民主专制制度", Store.YES);

		doc.add(field);
		doc.add(title);
		doc.add(content);

		indexWriter.addDocument(doc);

		indexWriter.close();
	}
	@Test
	public void testSearcher() throws IOException {

		Directory directory = FSDirectory.open(new File("indexDir/"));

		IndexReader indexReader = DirectoryReader.open(directory);

		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		Query query = new TermQuery(new Term("id", "1"));
		TopDocs topDocs = indexSearcher.search(query, 100);
		System.out.println("总记录：" + topDocs.totalHits);

		ScoreDoc scoreDocs[] = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int docID=scoreDoc.doc;
			Document document= indexSearcher.doc(docID);
			System.out.println(document.get("id"));
			System.out.println(document.get("title"));
			System.out.println(document.get("content"));
		}
	}
}
