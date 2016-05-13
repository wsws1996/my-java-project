package com.wang.ssm.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.ssm.po.User;
import com.wang.ssm.service.UserService;

public class UserServiceImplTest {
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(new String[] { "spring/applicationContent.xml",
				"spring/applicationContent-dao.xml", "spring/applicationContent-service.xml" });
	}

	@Test
	public void testFindUserById() throws Exception {
		UserService userService = (UserService) applicationContext.getBean("userService");
		User user = userService.findUserById(10);
		System.out.println(user);
	}

	@Test
	public void testSaveUser() throws Exception {
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.saveUser();
	}
}
