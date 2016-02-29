package cn.wang.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private String id;
	private String name;
	
	private Set<Employee> employees=new HashSet<Employee>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
