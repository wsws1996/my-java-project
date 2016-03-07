package cn.wang.s2sh.test;

import org.junit.Test;

public class SessionFactoryTest extends SpringUtils {
	@Test
	public void testSessionFactory(){
		 context.getBean("sessionFactory");
	}
}
