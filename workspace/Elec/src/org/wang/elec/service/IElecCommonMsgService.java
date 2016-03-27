package org.wang.elec.service;

import org.wang.elec.domain.ElecCommonMsg;


public interface IElecCommonMsgService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecCommonMsgServiceImpl";

	ElecCommonMsg findCommonMsg();

	void saveCommonMsg(ElecCommonMsg elecCommonMsg);
	
}
