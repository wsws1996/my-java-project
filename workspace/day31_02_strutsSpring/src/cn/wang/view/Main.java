package cn.wang.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.service.BusinessServlce;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"application.xml");

		BusinessServlce servlce = (BusinessServlce) applicationContext
				.getBean("businessService");
		BusinessServlce servlce1 = (BusinessServlce) applicationContext
				.getBean("businessService");
		servlce.m1();
		System.out.println(servlce == servlce1);
	}

}
