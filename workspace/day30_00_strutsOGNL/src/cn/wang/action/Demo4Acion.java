package cn.wang.action;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.enterprise.inject.New;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo4Acion extends ActionSupport {

	private String username = "test";

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
		Calendar c1 = Calendar.getInstance();
		c1.set(2000, 0, 1);
		valueStack.push(c1.getTime());
		
		Calendar c11=Calendar.getInstance();
		c11.set(2016, 6, 20);
		valueStack.push(c11.getTime());
		
		Calendar c2=Calendar.getInstance();
		c2.set(2016, 11, 20);
		valueStack.push(c2.getTime());
		valueStack.push("test");
		ActionContext.getContext().put("p1", "ppppppp1");
		return SUCCESS;
	}
}