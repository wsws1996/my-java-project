package cn.wang.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String register() {
		System.out.println(birthday);
		return null;
	}
}
