package cn.wang.spring.aop.xml.exception.dao.impl;

import cn.wang.spring.aop.xml.exception.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		int a=1/0;
	}

	@Override
	public void updatePerson() {
		Long.parseLong("aaa");
	}

}
