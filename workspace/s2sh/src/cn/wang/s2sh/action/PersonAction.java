package cn.wang.s2sh.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
		Person person = new Person();
		person.setName("asdf");
		personService.savePerson(person);
		System.out.println(ServletActionContext.getRequest());
		class MyThread extends Thread {
			@Override
			public void run() {
				System.out.println(ServletActionContext.getRequest());
				super.run();
			}
		}
		MyThread myThread = new MyThread();
		// myThread.start();
		return null;
	}

	public String showPerson() {
		int a = 1 / 0;
		Person person = this.personService.getPersonById(1L);
		ServletActionContext.getRequest().setAttribute("person", person);
		return "index";
	}
}
