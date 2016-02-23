package cn.wang.service.impl;

import cn.wang.dao.SomeDao;
import cn.wang.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private SomeDao dao;

	public void setDao(SomeDao dao) {
		this.dao = dao;
	}

	@Override
	public void m1() {
		dao.m1();
	}

}
