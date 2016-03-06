package cn.wang.spring.hibernate.transaction.service.impl;

import cn.wang.spring.hibernate.transaction.dao.PersonDao;
import cn.wang.spring.hibernate.transaction.domain.Person;
import cn.wang.spring.hibernate.transaction.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void savePerson(Person person) {
		personDao.savePerson(person);
	}

}
