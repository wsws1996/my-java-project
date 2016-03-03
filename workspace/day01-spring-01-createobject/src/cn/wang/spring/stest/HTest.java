package cn.wang.spring.stest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.spring.action.PersonAction;
import cn.wang.spring.di.xml.setter.Person;
import cn.wang.spring.extend.Student;
import cn.wang.spring.iocdi.document.DocumentManager;

public class HTest {
	@Test
	public void test() {
		 ApplicationContext context = new ClassPathXmlApplicationContext(
		 "applicationContext.xml");
		 PersonAction personAction=(PersonAction) context.getBean("personAction");
		 personAction.savePerson();
	}
}
