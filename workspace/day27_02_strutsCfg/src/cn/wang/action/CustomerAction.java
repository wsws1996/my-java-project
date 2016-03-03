package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6427665046050036428L;
	public String add() {
		System.out.println("add");
		return SUCCESS;
	}
	public String edit() {
		System.out.println("edit");
		return SUCCESS;
	}
	public String delete() {
		System.out.println("delete");
		return SUCCESS;
	}
	public String find() {
		System.out.println("find");
		return SUCCESS;
	}
}
