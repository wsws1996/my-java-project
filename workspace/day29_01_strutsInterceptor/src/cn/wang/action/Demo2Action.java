package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5049643885212697492L;

	public String add() {
		System.out.println("执行了添加");
		return null;
	}

	public String query() {
		System.out.println("执行了查询");
		return null;
	}
}
