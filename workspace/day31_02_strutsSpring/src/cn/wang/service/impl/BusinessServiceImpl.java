package cn.wang.service.impl;

import cn.wang.dao.SomeDao;
import cn.wang.service.BusinessServlce;

public class BusinessServiceImpl implements BusinessServlce {
	private SomeDao dao;

	public void setDao(SomeDao dao) {
		this.dao = dao;
	}

	@Override
	public void m1() {
		dao.m1();
	}

}
