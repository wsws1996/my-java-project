package org.wang.elec.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.NumericUtils;
import org.apache.lucene.util.Version;
import org.wang.elec.domain.ElecFileUpload;

public class LuceneUtils {
	/** 向索引库中添加数据 */
	public static void addIndex(ElecFileUpload fileUpload) {
		Document document = FileUploadDocument.FileUploadToDocument(fileUpload);
		try {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
					Version.LUCENE_36, Configuration.getAnalyzer());
			IndexWriter indexWriter = new IndexWriter(
					Configuration.getDirectory(), indexWriterConfig);
			indexWriter.addDocument(document);
			indexWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @name searcherIndexByCondition
	 * @description 使用查询条件，搜索索引库的数据，返回 List<ElecFileUpload>
	 * @author wang
	 * @createDate 2016年4月24日
	 * @param projId
	 *            所属单位
	 * @param belongTo
	 *            图纸类别
	 * @param queryString
	 *            文件名称和文件描述
	 */
	@SuppressWarnings("deprecation")
	public static List<ElecFileUpload> searcherIndexByCondition(String projId,
			String belongTo, String queryString) {
		List<ElecFileUpload> fileUploadList = new ArrayList<ElecFileUpload>();
		try {
			IndexSearcher indexSearcher = new IndexSearcher(
					IndexReader.open(Configuration.getDirectory()));
			BooleanQuery query = new BooleanQuery();

			if (StringUtils.isNotBlank(projId)) {
				TermQuery query1 = new TermQuery(new Term("projId", projId));
				query.add(query1, Occur.MUST);
			}

			if (StringUtils.isNotBlank(belongTo)) {
				TermQuery query2 = new TermQuery(new Term("belongTo", belongTo));
				query.add(query2, Occur.MUST);
			}

			if (StringUtils.isNotBlank(queryString)) {
				QueryParser queryParser = new MultiFieldQueryParser(
						Version.LUCENE_36,
						new String[] { "fileName", "comment" },
						Configuration.getAnalyzer());
				Query query3 = queryParser.parse(queryString);
				query.add(query3, Occur.MUST);
			}

			TopDocs topDocs = indexSearcher.search(query, 100);// 100代表返回前100条数据
			System.out.println("查询总记录数：" + topDocs.totalHits);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			// 添加文字高亮
			Formatter formatter = new SimpleHTMLFormatter("<font color='red'><b>","</b></font>");
			Scorer scorer = new QueryScorer(query);
			Highlighter highlighter = new Highlighter(formatter, scorer);
			int fragmentSize = 10;
			Fragmenter fragmenter = new SimpleFragmenter(fragmentSize);
			highlighter.setTextFragmenter(fragmenter);

			if (scoreDocs != null && scoreDocs.length > 0) {
				for (ScoreDoc scoreDoc : scoreDocs) {
					System.out.println("相关度得分：" + scoreDoc.score);
					int doc = scoreDoc.doc;
					Document document = indexSearcher.doc(doc);
					String fileName = highlighter.getBestFragment(
							Configuration.getAnalyzer(), "fileName",
							document.get("fileName"));
					if (StringUtils.isBlank(fileName)) {
						fileName=document.get("fileName");
						if (fileName!=null&&fileName.length()>fragmentSize) {
							fileName=fileName.substring(0, fragmentSize);
						}
					}
					document.getField("fileName").setValue(fileName);
					String comment = highlighter.getBestFragment(
							Configuration.getAnalyzer(), "comment",
							document.get("comment"));
					if (StringUtils.isBlank(comment)) {
						comment=document.get("comment");
						if (comment!=null&&comment.length()>fragmentSize) {
							comment=comment.substring(0, fragmentSize);
						}
					}
					document.getField("comment").setValue(comment);
					ElecFileUpload elecFileUpload = FileUploadDocument
							.documentToFileUpload(document);
					fileUploadList.add(elecFileUpload);
				}
			}
			indexSearcher.close();
		} catch (Exception e) {
		}
		return fileUploadList;
	}

	public static void deleteIndex(Integer seqId) {
		String id=NumericUtils.intToPrefixCoded(seqId);
		Term term=new Term("seqId", id);
		try {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
					Version.LUCENE_36, Configuration.getAnalyzer());
			IndexWriter indexWriter = new IndexWriter(
					Configuration.getDirectory(), indexWriterConfig);
			indexWriter.deleteDocuments(term);
			indexWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
