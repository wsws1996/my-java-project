package junit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.wang.Person;

public class PersonTest2 {

	@Before
	public void setUp() throws Exception {
		System.out.println("测试方法运行之前");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("测试方法运行之后");
	}
	@Test
	public void testEat()
	{
		Person p=new Person();
		p.eat();
	}
	@Test
	public void testRun() {
		Person p=new Person();
		p.run();
	}

}
