package cn.wang.hibernate.sessioncache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.EntityEntry;
import org.hibernate.event.def.AbstractFlushingEventListener;
import org.hibernate.event.def.DefaultFlushEntityEventListener;
import org.junit.Test;

import cn.wang.hibernate.domain.Person;
import cn.wang.hibernate.utils.HibernateUtils;

public class SessionCacheTest {
	@Test
	public void test() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactory;
		Session session = sessionFactory.openSession();
		Person person=(Person) session.get(Person.class, 1L);
		session.clear();
		session.update(person);
		System.out.println(session.getStatistics().getEntityCount());
		session.close();
	}
}
