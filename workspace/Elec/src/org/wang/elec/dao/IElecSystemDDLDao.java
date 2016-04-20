package org.wang.elec.dao;


import java.util.List;
import java.util.Map;

import org.wang.elec.domain.ElecSystemDDL;

public interface IElecSystemDDLDao extends ICommonDao<ElecSystemDDL> {
	public static final String SERVICE_NAME = "org.wang.elec.dao.impl.ElecSystemDDLDaoImpl";

	List<ElecSystemDDL> findSystemDDLByDistinct();

	String findDdlNameByKeywordAndDdlCode(String keyword, String ddlCode);


}
