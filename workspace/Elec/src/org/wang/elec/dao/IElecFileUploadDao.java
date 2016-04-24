package org.wang.elec.dao;

import java.util.List;
import java.util.Map;

import org.wang.elec.domain.ElecFileUpload;

public interface IElecFileUploadDao extends ICommonDao<ElecFileUpload> {
	public static final String SERVICE_NAME = "org.wang.elec.dao.impl.ElecFileUploadDaoImpl";

	List<ElecFileUpload> findFileUploadListByCondition(String condition,
			Object[] params, Map<String, String> orderby);

}
