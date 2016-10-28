package com.wang;

import java.io.StringWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Test;

import com.wang.core.bean.user.Buyer;

/**
 * 购物车对象 转成JSON
 * 
 * @author wang
 *
 */
public class TestCookie {
	@Test
	public void testCookie() throws Exception {
		Buyer buyer = new Buyer();
		buyer.setUsername("test2016");

		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);

		// 流
		StringWriter str = new StringWriter();

		// 对象转JSON 写
		om.writeValue(str, buyer);
		System.out.println(str.toString());
		// JSON转对象 读
		Buyer b = om.readValue(str.toString(), Buyer.class);
		System.out.println(b);
	}
}
