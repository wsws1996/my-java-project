package cn.wang.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1473025873643418391L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(name);
		return null;
	}
	public String register1() throws Exception {
		Thread.sleep(1000);
		System.out.println(name);
		return SUCCESS;
	}

}
