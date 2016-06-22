package com.wang.ssm.dao.mapper;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/applicationContext.xml", "spring/applicationContext-dao.xml" });
	}

	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper= (UserMapper) applicationContext.getBean("userMapper");
		System.out.println(userMapper.findUserById(10));
	}

}
