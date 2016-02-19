package cn.wang.action;

import cn.wang.domain.Person;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4822557785292449151L;
	private Person person=new Person();

	public Person getPerson() {
		System.out.println("getter");
		return person;
	}

	public void setPerson(Person person) {
		System.out.println("setter");
		this.person = person;
	}

	public String register() {
		System.out.println(person);
		if ("张三".equals(person.getUsername())
				&& "123456".equals(person.getPassword())) {
			return SUCCESS;
		}
		return LOGIN;
	}
}
