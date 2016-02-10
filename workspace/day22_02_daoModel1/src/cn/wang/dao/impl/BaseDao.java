package cn.wang.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.wang.dao.Dao;
import cn.wang.util.SessionFactoryUtil;

public abstract class BaseDao<T> implements Dao<T> {

	private Class<T> clazz;

	public BaseDao(Class<T> clazz) {
		this.clazz = clazz;
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
			T t= (T) session.get(clazz, id);
			session.delete(t);
			transaction.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

}
