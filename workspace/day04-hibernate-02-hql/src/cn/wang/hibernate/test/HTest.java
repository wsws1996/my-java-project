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
		List classes=session.createQuery("select cid, name from Classes").list();
		System.out.println("test gitttthub");
		session.close();
	}
}
