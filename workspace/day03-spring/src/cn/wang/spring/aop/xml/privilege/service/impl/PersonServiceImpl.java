package cn.wang.spring.aop.xml.privilege.service.impl;

import cn.wang.spring.aop.xml.privilege.annotation.PrivilegeInfo;
import cn.wang.spring.aop.xml.privilege.service.PersonService;

public class PersonServiceImpl implements PersonService {
	@PrivilegeInfo(name = "savePerson")
	@Override
	public void savePerson() {
		System.out.println("person saved");
	}

	@PrivilegeInfo(name = "updatePerson")
	@Override
	public void updatePerson() {
		System.out.println("person updated");
	}

}
