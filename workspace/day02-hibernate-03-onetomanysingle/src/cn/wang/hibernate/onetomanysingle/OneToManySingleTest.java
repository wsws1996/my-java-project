package cn.wang.hibernate.onetomanysingle;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.utils.HibernateUtils;

public class OneToManySingleTest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.getCurrentSession();

		Transaction transaction = session.beginTransaction();
		Classes classes = (Classes) session.get(Classes.class, 1L);
		session.delete(classes);
		transaction.commit();
	}
}
