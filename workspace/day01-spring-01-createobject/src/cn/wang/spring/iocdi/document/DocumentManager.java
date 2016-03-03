package cn.wang.spring.iocdi.document;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("documentManager")
public class DocumentManager {
	@Resource(name="wordDocument")
	private Document document;

	public void readDocument() {
		this.document.readDocument();
	}
	public void writeDocument() {
		this.document.writeDocument();
		
	}
}
