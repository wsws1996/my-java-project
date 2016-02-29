package cn.wang.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.wang.hibernate.domain.Course;
import cn.wang.hibernate.domain.Student;
import cn.wang.hibernate.utils.HibernateUtils;

public class ManyToManyTest {
	@Test
	public void test() {
		Session session = HibernateUtils.sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Student student = (Student) session.get(Student.class, 1L);

		Set<Course> courses = new HashSet<Course>();

		Course course = (Course) session.get(Course.class, 3L);
		courses.add(course);
		
		student.setCourses(courses);

		session.save(student);

		transaction.commit();
	}
}
