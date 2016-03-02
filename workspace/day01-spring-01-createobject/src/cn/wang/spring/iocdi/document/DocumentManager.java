package cn.wang.spring.iocdi.document;

public class DocumentManager {
	private Document document;

	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public void readDocument() {
		this.document.readDocument();
	}
	public void writeDocument() {
		this.document.writeDocument();
		
	}
}
