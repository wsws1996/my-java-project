package cn.wang.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Person;
import cn.wang.hibernate.utils.HibernateUtils;

public class SessionTest {
	@SuppressWarnings("unused")
	@Test
	public void test() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactory;
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Person person= (Person) session.get(Person.class, 1L);
		transaction.commit();
	}
}
