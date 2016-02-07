package cn.wang.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;

import cn.wang.domain.Product;

public class JSONDemo {
	@Test
	public void test1() {
		String string[] = { "a", "b", "c" };
		JSONArray jsonArray = JSONArray.fromObject(string);
		System.out.println(jsonArray);
	}
	@Test
	public void test2(){
		List<String> list=new ArrayList<String>();
		list.add("d");
		list.add("b");
		list.add("c");
		JSONArray jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}
	@Test
	public void test3(){
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(1, "砂糖", 12));
		list.add(new Product(2, "瓜子", 1));
		list.add(new Product(3, "豆油", 20));
		JSONArray jsonArray=JSONArray.fromObject(list);
		System.out.println(jsonArray);
	}
	@Test
	public void test4(){
		Product product=new Product(1, "瓜子", 14);
		List<Product> list=new ArrayList<Product>();
		list.add(product);
		JSONArray jsonArray=JSONArray.fromObject(product);
		System.out.println(jsonArray);
	}
	@Test
	public void test5(){
		Product product=new Product(1, "瓜子", 14);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"id"});
		JSONObject jsonObject=JSONObject.fromObject(product,jsonConfig);
		System.out.println(jsonObject);
	}
}
