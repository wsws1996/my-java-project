package com.wang;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danga.MemCached.MemCachedClient;
import com.wang.common.junit.SpringJunitTest;
import com.wang.core.bean.user.Buyer;

public class TestMemcached extends SpringJunitTest {

	@Autowired
	private MemCachedClient memCachedClient;

	@Test
	public void testAdd() throws Exception {
		// memCachedClient.set("12", "我是");
		// Object object = memCachedClient.get("ww");
		// System.out.println(object);
		Buyer buyer = new Buyer();
		buyer.setUsername("王五1");
		memCachedClient.set("ww1", buyer);
	}
}

