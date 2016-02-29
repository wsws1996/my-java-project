package cn.wang.dao;

import java.io.Serializable;

public interface Dao<T> {
	void add(T t);

	void update(T t);
	
	T findOne(Serializable id);

	void del(Serializable id);
}
