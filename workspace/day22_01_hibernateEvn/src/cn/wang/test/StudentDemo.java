package cn.wang.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.domain.Student;
import cn.wang.util.SessionFactoryUtil;

public class StudentDemo {
	@Test
	public void testAdd() {
		Session session = null;
		try {
			Student student = new Student();
			student.setName("张三");
			student.setBirthday(new Date());
			session = SessionFactoryUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Test
	public void testFindOne() {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			Student student = (Student) session.get(Student.class, 2);
			System.out.println(student);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdate() {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			Student student = (Student) session.get(Student.class, 2);
			student.setName("李四");
			Transaction transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testDel() {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			Student student = (Student) session.get(Student.class, 2);
			Transaction transaction = session.beginTransaction();
			session.delete(student);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}
}
