package cn.wang.s2sh.action;

import java.util.List;

import cn.wang.s2sh.domain.Privilege;
import cn.wang.s2sh.service.PrivilegeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PrivilegeAction extends ActionSupport {
	private PrivilegeService privilegeService;

	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}

	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	public String showPrivilegeTree() {
		List<Privilege> privileges=this.privilegeService.getPrivilegeTree();
		ActionContext.getContext().getValueStack().push(privileges);
		
		return SUCCESS;
	}
}
