package org.wang.elec.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.wang.elec.dao.ICommonDao;
import org.wang.elec.utils.TUtils;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements
		ICommonDao<T> {

	@SuppressWarnings("rawtypes")
	Class entityClass = TUtils.getActualType(this.getClass());

	@Resource(name = "sessionFactory")
	public void SetDi(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findObjectByID(Serializable id) {

		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void deleteObjectByIds(Serializable... ids) {
		if (ids != null && ids.length > 0) {
			for (Serializable id : ids) {
				Object entity = this.findObjectByID(id);
				this.getHibernateTemplate().delete(entity);
			}
		}
	}

	@Override
	public void deleteObjectByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}

	@Override
	public List<T> findCollectionByConditionNoPage(String condition,
			final Object[] params, Map<String, String> orderby) {

		String hql = "from " + entityClass.getSimpleName() + " o where 1=1 ";

		String orderbyCondiction = this.orderbyHql(orderby);

		final String finalHql = hql + condition + orderbyCondiction;
		// List<T> list = this.getHibernateTemplate().find(finalHql, params);

		// SessionFactory factory = this.getHibernateTemplate()
		// .getSessionFactory();
		// Session session = factory.getCurrentSession();
		// Query query = session.createQuery(finalHql);
		// if (params != null && params.length > 0) {
		// for (int i = 0; i < params.length; i++) {
		// query.setParameter(i, params[i]);
		// }
		// }
		//
		// List<T> list = query.list();

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final List<T> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(finalHql);
						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						return query.list();
					}
				});

		return list;
	}

	private String orderbyHql(Map<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			buffer.append(" ORDER BY ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(map.getKey() + " " + map.getValue() + ",");
			}
			buffer.deleteCharAt(buffer.length() - 1);

		}
		return buffer.toString();
	}

	@Override
	public List<T> findCollectionByConditionNoPageWithCache(String condition,
			final Object[] params, Map<String, String> orderby) {
		String hql = "from " + entityClass.getSimpleName() + " o where 1=1 ";

		String orderbyCondiction = this.orderbyHql(orderby);

		final String finalHql = hql + condition + orderbyCondiction;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final List<T> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public List<T> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(finalHql);
						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						query.setCacheable(true);
						return query.list();
					}
				});

		return list;
	}
}
