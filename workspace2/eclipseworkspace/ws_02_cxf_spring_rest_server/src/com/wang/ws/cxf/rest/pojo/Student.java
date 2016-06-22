package com.wang.ws.cxf.rest.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 学生信息
 * 
 * @author wang
 *
 */
@XmlRootElement(name = "student")
public class Student {
	private long id;
	private String name;
	private Date birthday;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
