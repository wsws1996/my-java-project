package org.wang.elec.service;

import java.util.Hashtable;
import java.util.List;

import org.wang.elec.domain.ElecPopedom;
import org.wang.elec.domain.ElecRole;
import org.wang.elec.domain.ElecUser;



public interface IElecRoleService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecRoleServiceImpl";

	List<ElecRole> findAllRoleList();

	List<ElecPopedom> findAllPopedomList();

	List<ElecPopedom> findAllPopedomListByRoleID(String roleID);

	List<ElecUser> findAllUserListByRoleID(String roleID);

	void saveRole(ElecPopedom elecPopedom);

	String findPopedomByRoleIDs(Hashtable<String, String> ht);

	List<ElecPopedom> findPopedomListByString(String popedom);

	boolean findRolePopedomByID(String roleID, String mid, String pid);

	
}
