package org.wang.elec.dao;


import java.util.List;

import org.wang.elec.domain.ElecRolePopedom;

public interface IElecRolePopedomDao extends ICommonDao<ElecRolePopedom> {
	public static final String SERVICE_NAME = "org.wang.elec.dao.impl.ElecRolePopedomDaoImpl";

	List<Object> findPopedomByRoleIDs(String condition);



}
