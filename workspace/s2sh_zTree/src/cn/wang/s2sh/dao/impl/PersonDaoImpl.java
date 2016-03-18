package cn.wang.s2sh.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wang.s2sh.dao.PersonDao;
import cn.wang.s2sh.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	@Override
	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

	@Override
	public Person getPersonById(Serializable id) {
		
		Person person= this.getHibernateTemplate().load(Person.class, id);
		return person;
	}

}
