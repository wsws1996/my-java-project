package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo4Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4782429130985577387L;

	public String m1() {
		System.out.println("m1");
		return NONE;
	}

	public String m2() {
		System.out.println("m2");
		return NONE;
	}

	public String m3() {
		System.out.println("m3");
		return NONE;
	}
}
