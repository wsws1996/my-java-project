package cn.wang.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo6Action extends ActionSupport {
	private String g="fff";
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	/**
	 * @return
	 */
	public String execute() {
		ServletActionContext.getRequest().setAttribute("p1", "ppp1");
		ActionContext.getContext().put("p1", "ppppp111");
		ActionContext.getContext().put("pp2", "ppppp22");
		return SUCCESS;
	}
}