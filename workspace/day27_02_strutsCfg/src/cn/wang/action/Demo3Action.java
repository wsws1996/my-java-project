package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3Action extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5137342011393247919L;
	public String addUI() {
		System.out.println("addUI");
		return SUCCESS;
	}
	public String editUI() {
		System.out.println("editUI");
		return SUCCESS;
	}
}
