package cn.wang.hibernate.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.utils.HibernateUtils;

public class HTest {
	@Test
	public void test() throws InterruptedException {
		Session session = HibernateUtils.sessionFactory.openSession();
		Query query = session.createQuery("select name from Classes");
		query.setCacheable(true);
		query.list();
		session.close();

		session = HibernateUtils.sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, 1L);
		classes.setName("us");

		transaction.commit();
		session.close();

		session = HibernateUtils.sessionFactory.openSession();
		query = session.createQuery("select name from Classes");
		query.setCacheable(true);
		query.list();
		session.close();
	}
}
