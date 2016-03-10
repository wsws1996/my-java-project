package org.wang.crm.service.base.impl;

import java.io.Serializable;
import java.util.List;

import org.wang.crm.dao.base.CommonDao;
import org.wang.crm.service.base.CommonService;

public abstract class CommonServiceImpl<T> implements CommonService<T> {

	public abstract CommonDao<T> getCommonDao();

	@Override
	public List<T> findAllEntry() {
		return this.getCommonDao().findAllEntry();
	}

	@Override
	public void saveEntry(T t) {
		this.getCommonDao().saveEntry(t);

	}

	@Override
	public void updateEntry(T t) {
		this.getCommonDao().updateEntry(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		this.getCommonDao().deleteEntry(id);
	}

	@Override
	public T getEntryByID(Serializable id) {
		return (T) this.getCommonDao().getEntryByID(id);
	}

}
