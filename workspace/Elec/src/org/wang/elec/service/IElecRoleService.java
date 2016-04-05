package org.wang.elec.service;

import java.util.List;

import org.wang.elec.domain.ElecPopedom;
import org.wang.elec.domain.ElecRole;



public interface IElecRoleService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecRoleServiceImpl";

	List<ElecRole> findAllRoleList();

	List<ElecPopedom> findAllPopedomList();

	List<ElecPopedom> findAllPopedomListByRoleID(String roleID);

	
}
