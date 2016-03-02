package cn.wang.spring.createobject.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.spring.action.PersonAction;
import cn.wang.spring.createobject.HelloWorld;
import cn.wang.spring.di.xml.setter.Person;
import cn.wang.spring.di.xml.setter.Student;
import cn.wang.spring.iocdi.document.Document;
import cn.wang.spring.iocdi.document.DocumentManager;
import cn.wang.spring.iocdi.document.WordDocument;

public class HTest {
	@Test
	public void test() {
		 ApplicationContext context = new ClassPathXmlApplicationContext(
		 "applicationContext.xml");
		PersonAction personAction=(PersonAction) context.getBean("personAction");
		personAction.savePerson();
	}
}
