package org.wang.elec.service;

import java.util.List;

import org.wang.elec.domain.ElecUser;


public interface IElecUserService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecUserServiceImpl";

	List<ElecUser> findUserListByCondition(ElecUser elecUser);

	String checkUser(String logonName);

	void saveUser(ElecUser elecUser);

}
