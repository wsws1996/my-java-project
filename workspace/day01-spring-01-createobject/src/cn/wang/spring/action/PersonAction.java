package cn.wang.spring.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.wang.spring.service.PersonService;

@Controller("personAction")
@Scope("prototype")
public class PersonAction {
	@Resource(name = "personService")
	private PersonService personService;


	public void savePerson() {
		this.personService.savePerson();
	}

}
