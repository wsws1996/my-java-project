package cn.wang.spring.iocdi.document;

import org.springframework.stereotype.Component;

@Component("excelDocument")
public class ExcelDocument implements Document {

	@Override
	public void readDocument() {
		System.out.println("excel read");
	}

	@Override
	public void writeDocument() {
		System.out.println("excel write");
	}

}
