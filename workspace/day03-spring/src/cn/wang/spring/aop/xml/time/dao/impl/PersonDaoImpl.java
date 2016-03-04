package cn.wang.spring.aop.xml.time.dao.impl;

import cn.wang.spring.aop.xml.time.dao.PersonDao;

public class PersonDaoImpl implements PersonDao {

	@Override
	public void savePerson() {
		try {
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("save person");
	}

}
