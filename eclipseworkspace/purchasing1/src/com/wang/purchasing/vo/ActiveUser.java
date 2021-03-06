package com.wang.purchasing.vo;

import java.util.Iterator;
import java.util.List;


/**
 * 用户身份信息，存入session
 * 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * @author Thinkpad
 *
 */
public class ActiveUser  implements java.io.Serializable {

	private String userid;//用户id
	private String username;//用户名称
	private String groupid;//用户类型
	private String groupname;//用户类型名称


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}



	/*public String getLogintype() {
		return logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}*/



	public String getGroupname() {
		return groupname;
	}

	
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	

/*	public Operation getActionUrl(String actionUrl) {
		if (operationList != null) {
			
			for (Iterator<Operation> o_list = operationList.iterator(); o_list.hasNext();) {
				Operation o_i = (Operation) o_list.next();
				if (actionUrl.indexOf(o_i.getActionUrl())>0) {
					return o_i;
				}
			}
		}
		return null;
	}*/
	

}
