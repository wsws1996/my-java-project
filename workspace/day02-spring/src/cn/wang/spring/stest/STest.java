package cn.wang.spring.stest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.spring.xml.transaction.PersonDao;
import cn.wang.spring.xml.transaction.PersonDaoImpl;

public class STest {
	@Test
	public void STest() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDao personDao=(PersonDao) context.getBean("personDao");
		personDao.savePerson();
	}
}
