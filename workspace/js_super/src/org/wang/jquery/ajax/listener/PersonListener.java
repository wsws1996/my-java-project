package org.wang.jquery.ajax.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.wang.jquery.ajax.bean.Person;

public class PersonListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person();
		person1.setPid(1L);
		person1.setName("person1");
		person1.setDescription("person1des");
		Person person2 = new Person();

		person2.setPid(2L);
		person2.setName("person2");
		person2.setDescription("person2des");

		Person person3 = new Person();
		person3.setPid(3L);
		person3.setName("person3");
		person3.setDescription("person3des");
//		Person person4 = new Person();
//		person4.setPid(4L);
//		person4.setName("person4");
//		person4.setDescription("person4des");
//		Person person5 = new Person();
//		person5.setPid(5L);
//		person5.setName("person5");
//		person5.setDescription("person5des");
//		Person person6 = new Person();
//		person6.setPid(6L);
//		person6.setName("person6");
//		person6.setDescription("person6des");
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
//		persons.add(person4);
//		persons.add(person5);
//		persons.add(person6);
		
		sce.getServletContext().setAttribute("persons", persons);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
