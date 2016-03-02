package cn.wang.spring.iocdi.document;

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
