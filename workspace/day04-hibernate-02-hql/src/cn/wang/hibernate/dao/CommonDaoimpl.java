package cn.wang.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;

import cn.wang.hibernate.utils.HibernateUtils;

public class CommonDaoimpl<T> implements CommonDao<T> {

	private Class classt;

	private ClassMetadata classMetadata;

	public CommonDaoimpl() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.classt = (Class) type.getActualTypeArguments()[0];
		this.classMetadata = HibernateUtils.sessionFactory
				.getClassMetadata(this.classt);
	}

	public List<T> getAllEntry() {
		Session session = HibernateUtils.sessionFactory.openSession();
		List<T> list = session.createQuery("from " + this.classt.getName())
				.list();
		return list;
	}

	public Long getCount() {
		Session session = HibernateUtils.sessionFactory.openSession();
		Long count = (Long) session.createQuery(
				"select count("
						+ this.classMetadata.getIdentifierPropertyName()
						+ ") from " + this.classt.getName()).uniqueResult();
		return count;
	}

	public List<T> getEntriesByCondition(Map<String, Object> keyValues) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from " + this.classt.getName());
		buffer.append(" where 1=1 ");
		for (Entry<String, Object> entry : keyValues.entrySet()) {
			buffer.append("and " + entry.getKey() + "=:" + entry.getKey());
		}
		Session session = HibernateUtils.sessionFactory.openSession();
		Query query = session.createQuery(buffer.toString());
		for (Entry<String, Object> entry : keyValues.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.list();
	}

	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		baseQuery.buildWhere();
		PageResult<T> pageResult=new PageResult<T>();
		pageResult.setCurrentPage(baseQuery.getCurrentPage());
		pageResult.setPageSize(baseQuery.getPageSize());
		StringBuffer buffer = new StringBuffer();
		buffer.append("from " + this.classt.getName());
		buffer.append(" where 1=1 ");
		for (Entry<String, Object> entry : baseQuery.getKeyValues().entrySet()) {
			buffer.append(" and " + entry.getKey() + "=:" + entry.getKey());
		}
		Session session = HibernateUtils.sessionFactory.openSession();
		Query query = session.createQuery(buffer.toString());
		for (Entry<String, Object> entry : baseQuery.getKeyValues().entrySet()) {
			System.out.println(entry.getValue());
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.setFirstResult(baseQuery.getCurrentPage());
		query.setMaxResults(baseQuery.getPageSize());
		List<T> rows=query.list();
		pageResult.setRows(rows);
		return pageResult;
	}

}
