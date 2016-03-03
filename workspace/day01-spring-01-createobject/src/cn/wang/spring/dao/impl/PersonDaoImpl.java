package cn.wang.spring.dao.impl;

import org.springframework.stereotype.Repository;

import cn.wang.spring.dao.PersonDao;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		System.out.println("save person");
	}

}
