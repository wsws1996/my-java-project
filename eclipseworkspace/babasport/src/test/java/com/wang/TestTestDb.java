package com.wang;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.wang.common.junit.SpringJunitTest;
import com.wang.core.bean.TestTb;
import com.wang.core.service.TestTbService;


public class TestTestDb extends SpringJunitTest{
	
	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void testAdd() throws Exception {
		TestTb testTb=new TestTb();
		testTb.setName("jll");
		testTbService.addTestTb(testTb);
	}
}
