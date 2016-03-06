package cn.wang.spring.aop.xml.stest;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import cn.wang.proxy.salary.Privilege;
import cn.wang.proxy.salary.SalaryManager;
import cn.wang.spring.hibernate.transaction.domain.Person;
import cn.wang.spring.hibernate.transaction.service.PersonService;
import cn.wang.spring.xml.transaction.PersonDao;

public class STest {
	@Test
	public void STest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PersonService personService=(PersonService) applicationContext.getBean("personService");
		Person person=new Person();
		person.setName("er");
		person.setDescription("fg");
		personService.savePerson(person);
	}
}
