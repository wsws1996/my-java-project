package junit.test;

import org.junit.Test;

import cn.wang.Person;

public class PersonTest {

	@Test
	public void testEat() {
		Person p=new Person();
		p.eat();
	}
	@Test
	public void testRun() {
		Person p=new Person();
		p.run();
	}
}
