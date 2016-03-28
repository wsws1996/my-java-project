package org.wang.elec.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.service.IElecSystemDDLService;

@Service(IElecSystemDDLService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecSystemDDLServiceImpl implements IElecSystemDDLService {
	
	/**
	 * 数据字典表Dao
	 */
	@Resource(name=IElecSystemDDLDao.SERVICE_NAME)
	IElecSystemDDLDao elecSystemDDLDao;

	/**
	 * @name:findSystemDDLByDistinct
	 * @description:数据字典的首页显示,去掉重复值
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-28
	 * @param: 无
	 * @return List<ElecSystemDDL> 存放数据类型的集合
	 */
	@Override
	public List<ElecSystemDDL> findSystemDDLByDistinct() {
		List<ElecSystemDDL> list=elecSystemDDLDao.findSystemDDLByDistinct();
		return list;
	}
}
