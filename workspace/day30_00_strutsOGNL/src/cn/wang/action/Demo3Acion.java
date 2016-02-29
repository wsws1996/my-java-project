package cn.wang.action;

import java.util.Date;
import java.util.Map;

import javax.enterprise.inject.New;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo3Acion extends ActionSupport {
	
	private String username="test";
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String execute() {
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		Map<String, Object> map = valueStack.getContext();
		ActionContext.getContext().put("p1", "pppp1");
		CompoundRoot root = valueStack.getRoot();
		System.out.println(root);
		valueStack.push(new Date());
		System.out.println(root);
//		valueStack.pop();
//		valueStack.pop();
//		System.out.println(root);
		System.out.println(valueStack.peek());
		return SUCCESS;
	}
}