package org.wang.utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexableField;
import org.wang.bean.Article;

/**
 * article的转换类
 * @author wang
 *
 */
public class ArticleUtils {
	/**
	 * 
	 * @description 将article转换为document 
	 * @author wang
	 * @version 
	 * @createDate 2016年5月1日
	 * @param article
	 * @return document对象
	 */
	public static Document articleToDocument(Article article) {
		Document document=new Document();
		IntField idField=new IntField("id", article.getId(), Store.YES);
		
		StringField authorField =new StringField("author", article.getAuthor(), Store.YES);
		StringField urlField =new StringField("link", article.getLink(), Store.YES);
		
		TextField titleField=new TextField("title", article.getTitle(),Store.YES);
//		titleField.setBoost(4f);
		TextField contentField=new TextField("content", article.getContent(), Store.YES);
		
		document.add(idField);
		document.add(authorField);
		document.add(urlField);
		document.add(titleField);
		document.add(contentField);
		
		return document;
	}
}
