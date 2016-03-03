package cn.wang.hibernate.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.domain.Student;
import cn.wang.hibernate.utils.HibernateUtils;

public class HTest {
	@Test
	public void test() throws InterruptedException {
		Session session = HibernateUtils.sessionFactory.openSession();
		List<Classes> classes=(List<Classes>) session.createQuery("from Classes").list();
		for (Classes classes2 : classes) {
			System.out.println(classes2.getName());
			Set<Student> students=classes2.getStudents();
			for (Student student : students) {
				System.out.println(student.getName());
			}
		}
		session.close();
	}
}
