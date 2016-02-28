package cn.wang.hibernate.domain;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
	/**
	 * 
	 */
	private Long sid;
	private String name;
	private String description;

	private Set<Course> courses;
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
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
