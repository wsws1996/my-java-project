package cn.wang.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtilsForDom4j {
	public static Document getDocument() throws DocumentException{
		SAXReader saxReader =new SAXReader();
		Document document= saxReader.read("src/student.xml");
		
		return document;
	}
	public static void write2Xml(Document document) throws IOException{
		OutputFormat format =OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(new FileOutputStream("src/student.xml"),format);
		writer.write(document);
		writer.close();
	}
}
