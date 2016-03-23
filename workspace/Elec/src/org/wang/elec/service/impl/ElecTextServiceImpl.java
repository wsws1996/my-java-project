package org.wang.elec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecTextDao;
import org.wang.elec.domain.ElecText;
import org.wang.elec.service.IElecTextService;

@Service(IElecTextService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecTextServiceImpl implements IElecTextService {

	@Resource(name = IElecTextDao.SERVICE_NAME)
	IElecTextDao elecTextDao;

	@Override
	@Transactional(readOnly = false)
	public void saveElecText(ElecText elecText) {
		elecTextDao.save(elecText);
	}

}
