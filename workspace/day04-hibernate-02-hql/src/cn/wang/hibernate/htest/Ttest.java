package cn.wang.hibernate.htest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.wang.hibernate.domain.Classes;
import cn.wang.hibernate.domain.Course;
import cn.wang.hibernate.utils.HibernateUtils;

public class Ttest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.openSession();

		List<Classes> classes = session
				.createQuery(
						"from Student s inner join fetch s.classes c"
						+ " inner join fetch s.courses cc")
				.list();

		session.close();
	}
}
