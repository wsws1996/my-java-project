package cn.wang.action;

import cn.wang.service.BusinessService;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	private BusinessService businessService;

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8914425323355440948L;

	/**
	 * @return
	 */
	public String execute() {
		businessService.m1();
		return null;
	}
}