package cn.wang.spring.aop.xml.stest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.spring.aop.xml.privilege.aspect.PrivilegeAspect;
import cn.wang.spring.aop.xml.privilege.bean.Privilege;
import cn.wang.spring.aop.xml.privilege.service.PersonService;
import cn.wang.spring.aop.xml.time.action.PersonAction;

public class STest {
	@Test
	public void STest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PersonAction personAction=(PersonAction) applicationContext.getBean("personAction");
		personAction.savePerson();
	}
}
