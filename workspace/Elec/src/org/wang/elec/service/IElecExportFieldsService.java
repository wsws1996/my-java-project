package org.wang.elec.service;

import org.wang.elec.domain.ElecExportFields;

public interface IElecExportFieldsService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecExportFieldsServiceImpl";

	ElecExportFields findExportFieldByID(String belongTo);

	void saveSetExportExcel(ElecExportFields elecExportFields);

}
