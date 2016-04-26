package org.wang.elec.service;

import java.util.ArrayList;
import java.util.List;

import org.wang.elec.domain.ElecUser;
import org.wang.elec.domain.ElecUserFile;


public interface IElecUserService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecUserServiceImpl";

	List<ElecUser> findUserListByCondition(ElecUser elecUser);

	String checkUser(String logonName);

	void saveUser(ElecUser elecUser);

	ElecUser findUserByID(String userID);

	ElecUserFile findUserFileByID(String fileID);

	void deleteUserByID(ElecUser elecUser);

	ElecUser findUserByLogonName(String name);

	ArrayList<String> findFieldNameWithExcel();

	ArrayList<ArrayList<String>> findFieldDataWithExcel(ElecUser elecUser);

}
