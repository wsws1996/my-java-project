package cn.wang.s2sh.domain;

import java.io.Serializable;

import org.hibernate.impl.SessionFactoryImpl;


public class Person implements Serializable{
	private Long pid;
	private String name;
	private String description;
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(){}
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
