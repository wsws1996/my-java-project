package org.wang.elec.service;

import java.util.List;

import org.wang.elec.domain.ElecFileUpload;

public interface IElecFileUploadService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecFileUploadServiceImpl";

	void saveFileUpload(ElecFileUpload elecFileUpload);

	List<ElecFileUpload> findFileUploadListByCondition(
			ElecFileUpload elecFileUpload);

	ElecFileUpload findFileByID(Integer fileID);

	List<ElecFileUpload> findFileUploadByLuceneCondition(
			ElecFileUpload elecFileUpload);

	void deleteFileUploadByID(Integer seqId);

}
