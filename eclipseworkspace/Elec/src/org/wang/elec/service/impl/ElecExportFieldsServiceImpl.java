package org.wang.elec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecExportFieldsDao;
import org.wang.elec.domain.ElecExportFields;
import org.wang.elec.service.IElecExportFieldsService;

@Service(IElecExportFieldsService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecExportFieldsServiceImpl implements IElecExportFieldsService {
	/** 导出设置表Dao **/
	@Resource(name = IElecExportFieldsDao.SERVICE_NAME)
	IElecExportFieldsDao elecExportFieldsDao;

	/**
	 * @name:findExportFieldByID
	 * @description:使用主键ID，查询对应的导出设置对象
	 * @author: wang
	 * @version: V1.0
	 * @create: Date: 2016-04-20
	 * @param: String：主键ID
	 * @return: ElecExportFields：PO对象
	 */

	@Override
	public ElecExportFields findExportFieldByID(String belongTo) {
		return elecExportFieldsDao.findObjectByID(belongTo);
	}

	/**
	 * @name:saveSetExportExcel
	 * @description:更新保存导出设置的操作
	 * @author: wang
	 * @version: V1.0
	 * @create: Date: 2016-04-20
	 * @param: ElecExportFields VO对象
	 * @return: 无
	 */

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveSetExportExcel(ElecExportFields elecExportFields) {
		elecExportFieldsDao.update(elecExportFields);
	}
}
