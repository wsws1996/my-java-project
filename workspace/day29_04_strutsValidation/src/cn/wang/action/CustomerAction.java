package cn.wang.action;

import java.util.Date;


import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2805100459911802698L;
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String abc() {
		System.out.println(birthday);
		return SUCCESS;
	}
	public String edit() {
		System.out.println(birthday);
		return SUCCESS;
	}
}
