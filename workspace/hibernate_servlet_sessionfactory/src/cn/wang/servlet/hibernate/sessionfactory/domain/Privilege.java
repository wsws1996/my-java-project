package cn.wang.servlet.hibernate.sessionfactory.domain;

import java.io.Serializable;

public class Privilege implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1875484591344725676L;
	private Long pid;
	private String name;
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
	
}
