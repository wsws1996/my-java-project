package cn.wang.spring.jdbc.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dtest {
	@Test
	public void test() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
		studentDao.saveStudent("insert into Student(name,description) values('bb','bb')");
	}
}
