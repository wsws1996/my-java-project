package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914425323355440948L;

	/**
	 * @return
	 */
	public String execute() {
		System.out.println(getText("hello"));
		return SUCCESS;
	}
}