package cn.wang.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletContext context=ServletActionContext.getServletContext();
		System.out.println(request);
		System.out.println(response);
		System.out.println(context);
		return null;
	}
}