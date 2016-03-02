package cn.wang.spring.di.xml.setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
	private Long pid;
	private String name;
	private Student student;
	private List lists;
	private Set sets;
	private Map map;
	private Properties properties;
	private Object [] objects;
	
	
	
	public Person() {
		super();
	}
	public Person(String name, Student student) {
		super();
		this.name = name;
		this.student = student;
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public Long getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
	public Student getStudent() {
		return student;
	}
	public List getLists() {
		return lists;
	}
	public Set getSets() {
		return sets;
	}
	public Map getMap() {
		return map;
	}
	public Properties getProperties() {
		return properties;
	}
	public Object[] getObjects() {
		return objects;
	}
	
}
