package cn.wang.spring.stest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.spring.extend.Student;

public class HTest {
	@Test
	public void test() {
		 ApplicationContext context = new ClassPathXmlApplicationContext(
		 "applicationContext.xml");
		Student student=(Student) context.getBean("student");
		System.out.println(student.getName());
	}
}
