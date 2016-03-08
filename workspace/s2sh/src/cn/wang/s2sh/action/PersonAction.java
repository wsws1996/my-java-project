package cn.wang.s2sh.action;

import cn.wang.s2sh.domain.Person;
import cn.wang.s2sh.service.PersonService;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public String savePerson() {
		Person person=new Person();
		person.setName("asdf");
		personService.savePerson(person);
		return null;
	}
}
