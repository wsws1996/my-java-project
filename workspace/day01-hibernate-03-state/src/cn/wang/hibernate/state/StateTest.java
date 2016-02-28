package cn.wang.hibernate.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Person;
import cn.wang.hibernate.utils.HibernateUtils;

public class StateTest {
	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactory;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Person person1=new Person();
		person1.setName("ghjk");
		person1.setDescription("58");
		session.save(person1);
		
		Person person2=(Person) session.get(Person.class, 1L);
		person2.setDescription("777");
		
		Person person3=(Person) session.get(Person.class, 2L);
		
		session.flush();
		
		transaction.commit();
		session.close();
	}
}
