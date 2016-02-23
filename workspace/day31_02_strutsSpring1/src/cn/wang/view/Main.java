package cn.wang.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.service.BusinessService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"application.xml");

		BusinessService servlce = (BusinessService) applicationContext
				.getBean("businessService");
		BusinessService servlce1 = (BusinessService) applicationContext
				.getBean("businessService");
		servlce.m1();
		System.out.println(servlce == servlce1);
	}

}
