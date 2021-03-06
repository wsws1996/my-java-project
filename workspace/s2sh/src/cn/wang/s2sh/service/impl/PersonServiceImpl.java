package cn.wang.s2sh.service.impl;

import java.io.Serializable;

import cn.wang.s2sh.dao.PersonDao;
import cn.wang.s2sh.domain.Person;
import cn.wang.s2sh.service.PersonService;

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
		this.personDao.savePerson(person);
	}

	@Override
	public Person getPersonById(Serializable id) {
		Person person = this.personDao.getPersonById(id);
		return person;
	}

}
