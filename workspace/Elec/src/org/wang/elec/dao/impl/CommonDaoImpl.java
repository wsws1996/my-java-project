package org.wang.elec.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wang.elec.dao.ICommonDao;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements
		ICommonDao<T> {

	@Resource(name = "sessionFactory")
	public void SetDi(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

}
