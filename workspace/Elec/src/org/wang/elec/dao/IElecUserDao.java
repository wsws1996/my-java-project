package org.wang.elec.dao;


import java.util.List;
import java.util.Map;

import org.wang.elec.domain.ElecUser;

public interface IElecUserDao extends ICommonDao<ElecUser> {
	public static final String SERVICE_NAME = "org.wang.elec.dao.impl.ElecUserDaoImpl";

	List<ElecUser> findCollectionByConditionNoPageWithSql(String condition,
			Object[] params, Map<String, String> orderby);



}
