package cn.wang.hibernate.domain;

import java.io.Serializable;
import java.util.Set;

public class Classes implements Serializable{
	private Long cid;
	private String name;
	private String description;
	
	private Set<Student> students;

	public Classes() {
	}
	
	
	public Classes(Long cid, String name) {
		this.cid = cid;
		this.name = name;
	}


	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
