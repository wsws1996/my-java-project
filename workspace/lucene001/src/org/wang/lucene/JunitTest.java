package org.wang.lucene;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.wang.bean.Article;
import org.wang.dao.LuceneDao;

public class JunitTest {
	private LuceneDao luceneDao=new LuceneDao();
	@Test
	public void addIndex() throws IOException {
		for (int i = 37; i <=37 ; i++) {
			Article article=new Article();
			
			article.setId(i);
			
			article.setTitle("java 是一种very important语言");
			
			article.setContent("在大谷仓一头一个凸起的台子上，麦哲已经安稳地坐在草垫子上了，在他头顶上方的房梁上悬挂着一盏马灯。他已");
			article.setAuthor("自由的旗帜");
			
			article.setLink("www.wang.org");
			luceneDao.addIndex(article);
		}
	}
	@Test
	public void testDel() throws IOException {
		luceneDao.delIndex("title", "发");
	}
	
	@Test
	public void testSearcher() throws Exception {
		String keywords="内容";
		List<Article> articles=luceneDao.findIndex(keywords,0,10);
		for (Article article : articles) {
			System.out.println(article.getId());
			System.out.println(article.getAuthor());
			System.out.println(article.getLink());
			System.out.println(article.getContent());
			System.out.println(article.getTitle());
		}
	}
	@Test
	public void testUpdate() throws IOException {
		String fieldName ="title";
		String fieldValue="故";
		
		Article article=new Article();
		article.setAuthor("test");
		article.setContent("内容");
		article.setId(1984);
		article.setLink("www.wang.org");
		article.setTitle("freedom");
		luceneDao.updateIndex(fieldName, fieldValue, article);
	}
}
