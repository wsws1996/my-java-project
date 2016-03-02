package cn.wang.spring.iocdi.document;

public class PdfDocument implements Document {

	@Override
	public void readDocument() {
		System.out.println("pdf read");
	}

	@Override
	public void writeDocument() {
		System.out.println("pdf write");
	}

}
