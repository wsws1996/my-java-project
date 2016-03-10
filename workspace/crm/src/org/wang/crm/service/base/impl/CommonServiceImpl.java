package org.wang.crm.service.base.impl;

import java.io.Serializable;
import java.util.List;

import org.wang.crm.dao.base.CommonDao;
import org.wang.crm.service.base.CommonService;

public class CommonServiceImpl<T> implements CommonService<T> {

	private CommonDao commonDao;

	public CommonDao getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public List<T> findAllEntry() {
		return this.commonDao.findAllEntry();
	}

	@Override
	public void saveEntry(T t) {
		this.commonDao.saveEntry(t);

	}

	@Override
	public void updateEntry(T t) {
		this.commonDao.updateEntry(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		this.commonDao.deleteEntry(id);
	}

	@Override
	public T getEntryByID(Serializable id) {
		return (T) this.commonDao.getEntryByID(id);
	}

}
