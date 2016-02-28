package cn.wang.servlet.hibernate.sessionfactory.dao;

import org.hibernate.Session;

import cn.wang.servlet.hibernate.sessionfactory.utils.HibernateUtils;

public class PrivilegeDao {
	public void putPrivilegesToSecondLevel() {
		Session session = HibernateUtils.sessionFactory.openSession();
		session.createQuery("from Privilege").list();
	}
}
