package org.wang.lucene;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class TestAnalyzer {
	public static void main(String[] args) throws IOException {
		Analyzer analyzer=new IKAnalyzer();
		String text="所有动物一例平等但有些动物比其他动物更加平等我们就会变得富裕而自由";
		testAnalyzer(analyzer, text);
	}

	public static void testAnalyzer(Analyzer analyzer, String text)
			throws IOException {
		System.out.println("当前使用的分词器：" + analyzer.getClass().getSimpleName());
		TokenStream tokenStream = analyzer.tokenStream("content",
				new StringReader(text));
		tokenStream.addAttribute(CharTermAttribute.class);
		tokenStream.reset();
		while (tokenStream.incrementToken()) {
			CharTermAttribute charTermAttribute = tokenStream
					.getAttribute(CharTermAttribute.class);
			System.out.println(new String(charTermAttribute.toString()));
		}

	}
}
