package cn.wang.s2sh.test;

import org.junit.Test;

import cn.wang.s2sh.action.PersonAction;
import cn.wang.s2sh.domain.Person;
import cn.wang.s2sh.service.PersonService;

public class PersonTest extends SpringUtils {
	@Test
	public void testSavePerson() {
		PersonService personService = (PersonService) context
				.getBean("personService");
		Person person = new Person();
		person.setName("asdf");
		personService.savePerson(person);
	}

	@Test
	public void testPersonAction() {
		PersonAction personAction=(PersonAction) context.getBean("personAction");
		personAction.savePerson();
	}
}
