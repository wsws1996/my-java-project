package cn.wang.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo1 {

	public static void main(String[] args) throws DocumentException, IOException {
		// TODO Auto-generated method stub
		add2();
	}
	@Test
	public void findUser() throws DocumentException {
		String username="aaa";
		String password="13";
		SAXReader saxReader =new SAXReader();
		Document document  =saxReader.read(new File("src/users.xml"));
		Element element= (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		if (element!=null) {
			System.out.println("登陆成功！！！");
		}else {
			System.out.println("用户名和/或密码错误！！！");
		}
	}
	@Test
	public void findWithXpath() throws DocumentException {
		SAXReader saxReader =new SAXReader();
		Document document  =saxReader.read(new File("src/book.xml"));
		Element element =(Element) document.selectNodes("//书名").get(1);
		System.out.println(element.getText());
	}
	public static void read() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element root = document.getRootElement();
		Element bookname = root.element("书").element("书名");
		System.out.println(bookname.getText());

	}

	public static void readAttr() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element root = document.getRootElement();
		Element bookname = root.element("书");
		System.out.println(bookname.attributeValue("name"));
	}

	public static void add() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element price = DocumentHelper.createElement("售价");
		price.setText("19元");

		document.getRootElement().element("书").add(price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"), format);
		writer.write(document);
		writer.close();
		System.out.println("success");
	}

	public static void update() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element price = (Element) document.getRootElement().element("书").elements("售价").get(1);
		price.setText("209元");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"), format);
		writer.write(document);
		writer.close();
	}

	public static void delete() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element price = (Element) document.getRootElement().element("书").elements("售价").get(1);
		price.getParent().remove(price);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"), format);
		writer.write(document);
		writer.close();
	}
	@SuppressWarnings("unchecked")
	public static void add2() throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		Element price = DocumentHelper.createElement("售价");
		price.setText("19元");
		@SuppressWarnings("rawtypes")
		List list= document.getRootElement().element("书").elements();
		list.add(1, price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"), format);
		writer.write(document);
		writer.close();
	}
}
