package cn.wang.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

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

}
