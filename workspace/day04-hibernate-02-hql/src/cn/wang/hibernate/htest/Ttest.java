package cn.wang.hibernate.htest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.utils.HibernateUtils;

public class Ttest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.openSession();

		Query query = session
				.createQuery("from Classes where cid=:cid and name=:name");
		query.setParameter("cid", 2L);
		query.setParameter("name", "sd");
		Classes classes = (Classes) query.uniqueResult();
		System.out.println(classes.getName());
		session.close();
	}
}
