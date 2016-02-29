package cn.wang.hibernate.onetomany;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.domain.Student;
import cn.wang.hibernate.utils.HibernateUtils;

public class OneToManyTest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.getCurrentSession();

		Transaction transaction = session.beginTransaction();
		Student student=(Student) session.get(Student.class, 1L);
		student.setClasses(null);
		
		transaction.commit();
	}
}
