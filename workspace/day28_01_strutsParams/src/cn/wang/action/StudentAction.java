package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String register() {
		System.out.println(name);
		return null;
	}
}
