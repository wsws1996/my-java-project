package cn.wang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo5Action extends ActionSupport {
	private String name = "ttt";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String execute() {
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		// valueStack.set("p1","pp1");
		// valueStack.set("p2", "pp2");
		valueStack.setValue("name", "shit1");
		valueStack.setValue("#abc", "aaa");
		System.out.println(valueStack.findString("name"));
		System.out.println(valueStack.findString("#abc"));
		System.out.println(valueStack.findString("abc"));
		return SUCCESS;
	}
}