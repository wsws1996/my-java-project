package cn.wang.spring.jdbc.template;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.orm.jdo.support.JdoDaoSupport;

public class StudentDaoTest {
	@Test
	public void test() throws SQLException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao=(StudentDao) applicationContext.getBean("studentDao2");
		studentDao.saveStudent();
	}
}
