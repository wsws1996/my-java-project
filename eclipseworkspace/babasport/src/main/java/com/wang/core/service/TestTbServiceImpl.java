package com.wang.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.core.bean.TestTb;
import com.wang.core.dao.TestTbDao;

@Service
@Transactional
public class TestTbServiceImpl implements TestTbService {

	@Resource
	private TestTbDao testTbDao;
	
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
		
		throw new RuntimeException();
	}

}
