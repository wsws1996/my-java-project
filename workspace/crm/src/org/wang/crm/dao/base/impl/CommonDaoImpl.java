package org.wang.crm.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.wang.crm.dao.base.CommonDao;
import org.wang.crm.domain.Department;

public class CommonDaoImpl<T> implements CommonDao<T> {

	private Class classt;

	public CommonDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.classt = (Class) type.getActualTypeArguments()[0];
	}

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<T> findAllEntry() {

		return this.hibernateTemplate.find("from " + this.classt.getName());
	}

	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);

	}

	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		T t = (T) this.hibernateTemplate.get(this.classt.getClass(), id);
		if (t!=null) {
			this.hibernateTemplate.delete(t);
		}
	}

	@Override
	public T getEntryByID(Serializable id) {

		return (T) this.hibernateTemplate.get(this.classt, id);
	}
}
