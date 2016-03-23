package org.wang.elec.service;

import org.wang.elec.domain.ElecText;

public interface IElecTextService {
	public static final String SERVICE_NAME = "org.wang.elec.service.impl.ElecTextServiceImpl";

	void saveElecText(ElecText elecText);
}
