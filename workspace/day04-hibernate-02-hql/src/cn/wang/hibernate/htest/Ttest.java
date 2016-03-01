package cn.wang.hibernate.htest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.wang.hibernate.domain.Course;
import cn.wang.hibernate.utils.HibernateUtils;

public class Ttest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.openSession();

		List<Course> courses= session.createQuery("from Course c left outer join fetch c.students s").list();
		
		session.close();
	}
}
