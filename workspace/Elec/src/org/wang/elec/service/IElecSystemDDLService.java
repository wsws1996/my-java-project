package org.wang.elec.service;

import java.util.List;

import org.wang.elec.domain.ElecSystemDDL;

public interface IElecSystemDDLService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecSystemDDLServiceImpl";

	List<ElecSystemDDL> findSystemDDLByDistinct();

	List<ElecSystemDDL> findSystemDDLByKeyword(String keyword);

	void saveSystemDDL(ElecSystemDDL elecSystemDDL);

	String findDdlNameByKeywordAndDdlCode(String string, String ddlCode);


}
