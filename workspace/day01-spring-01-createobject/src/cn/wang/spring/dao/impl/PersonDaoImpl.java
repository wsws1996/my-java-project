package cn.wang.spring.dao.impl;

import cn.wang.spring.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

}
