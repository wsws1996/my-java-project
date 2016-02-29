package cn.wang.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.wang.dao.Dao;
import cn.wang.util.SessionFactoryUtil;

public abstract class BaseDao<T> implements Dao<T> {

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public void add(T t) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOne(Serializable id) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			return (T) session.get(clazz, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T t) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void del(Serializable id) {
		Session session = null;
		try {
			session = SessionFactoryUtil.getSession();
			Transaction transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			T t = (T) session.get(clazz, id);
			session.delete(t);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

}
