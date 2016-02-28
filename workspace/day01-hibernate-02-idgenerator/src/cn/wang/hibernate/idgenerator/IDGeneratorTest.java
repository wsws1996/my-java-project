package cn.wang.hibernate.idgenerator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Person;
import cn.wang.hibernate.utils.HibernateUtils;

public class IDGeneratorTest {
	@Test
	public void test(){
		Session session= HibernateUtils.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Person person=new Person();
		person.setName("test");
		session.save(person);
		transaction.commit();
		session.close();
	}
}
