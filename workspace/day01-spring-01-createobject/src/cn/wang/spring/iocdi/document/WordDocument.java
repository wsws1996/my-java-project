package cn.wang.spring.iocdi.document;

import org.springframework.stereotype.Component;

@Component("wordDocument")
public class WordDocument implements Document {

	@Override
	public void readDocument() {
		System.out.println("word read");
	}

	@Override
	public void writeDocument() {
		System.out.println("word write");
	}

}
