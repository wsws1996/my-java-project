package cn.wang.spring.hibernate.transaction.dao.impl;

import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;

import cn.wang.spring.hibernate.transaction.dao.PersonDao;
import cn.wang.spring.hibernate.transaction.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {
	@Override
	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

}
