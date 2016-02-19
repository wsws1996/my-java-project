package cn.wang.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class Demo3Action {
	public String doSomething() throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.getWriter().write("yes");
		return null;
	}
}
