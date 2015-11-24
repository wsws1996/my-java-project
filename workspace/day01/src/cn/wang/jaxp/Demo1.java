package cn.wang.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo1 {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book.xml"));

		list(document);
	}

	public static void read(Document document) {
		NodeList list = document.getElementsByTagName("售价");
		Node price = list.item(0);
		String value = price.getTextContent();
		System.out.println(value);
	}

	public static void update() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book.xml"));
		Node price = document.getElementsByTagName("售价").item(0);
		price.setTextContent("Nah");

		// 将数据写入文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book.xml")));
	}

	@Test
	public void add() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book.xml"));
		Node price = document.createElement("售价");
		price.setTextContent("59元");

		// 得到父节点
		Node parent = document.getElementsByTagName("书").item(0);
		// 挂载子节点
		parent.appendChild(price);
		// 同步到文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book.xml")));
	}

	@Test
	public void add2() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book.xml"));
		Node price = document.createElement("售价");
		price.setTextContent("39元");

		Node parent = document.getElementsByTagName("书").item(0);
		parent.insertBefore(price, document.getElementsByTagName("书名").item(0));

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book.xml")));

	}

	@Test
	public void delete() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book.xml"));

		Node node = document.getElementsByTagName("售价").item(2);

		Node parent = node.getParentNode();
		parent.removeChild(node);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book.xml")));
	}

	@Test
	public void updateAttribute() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book.xml"));
		Node node = document.getElementsByTagName("书").item(0);
		Element book=null;
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			book=(Element)node;
			book.setAttribute("name", "zzzz");
			book.removeAttribute("password");
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book.xml")));
	}
	public static void list(Node node) {
		if (node.getNodeType()==Node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		NodeList list= node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child =list.item(i);
			list(child);
		}
	}
}
