package cn.wang.hibernate.onetoone;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.domain.Student;
import cn.wang.hibernate.utils.HibernateUtils;

public class HTest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Student student=(Student) session.get(Student.class, 1L);

		Student student2=(Student) session.get(Student.class, 2L);
		Classes classes=(Classes) session.get(Classes.class, 1L);
		
		student.setClasses(classes);
		student2.setClasses(classes);
		
		session.save(student);
		session.save(student2);
		
		transaction.commit();
	}
}
