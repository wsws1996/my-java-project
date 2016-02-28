package cn.wang.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.wang.hibernate.domain.Person;



public class PersonDao {
	@Test
	public void testSavePerson() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = new Person();
		person.setName("wefs");
		person.setDescription("ym");

		session.save(person);

		transaction.commit();
		session.close();
	}

	@Test
	public void testGetPersonById() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Person person = (Person) session.get(Person.class, 1L);
		System.out.println(person.getName());
		session.close();
	}
	@Test
	public void testUpdate() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = (Person) session.get(Person.class, 1L);
		person.setDescription("jsym");
		session.update(person);
		transaction.commit();
		session.close();
	}
	@Test
	public void testDelete() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Person person = (Person) session.get(Person.class, 1L);
		session.delete(person);
		transaction.commit();
		session.close();
	}
}
