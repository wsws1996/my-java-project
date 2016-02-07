package cn.wang.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.wang.domain.Product;

import com.thoughtworks.xstream.XStream;

public class XStreamDemo {
	@Test
	public void test1() {
		Product product = new Product(1, "test", 20);
		XStream xStream = new XStream();
		xStream.alias("product", Product.class);
		String xml = xStream.toXML(product);
		System.out.println(xml);
	}

	@Test
	public void test2() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "洗衣粉", 20));
		products.add(new Product(2, "水浒传", 10));
		products.add(new Product(3, "袜子", 10));
		products.add(new Product(4, "肥皂", 20));
		products.add(new Product(5, "节能灯", 7));
		XStream xStream = new XStream();
		xStream.alias("products", List.class);
		xStream.alias("product", Product.class);
		String xml = xStream.toXML(products);
		System.out.println(xml);
	}
}
