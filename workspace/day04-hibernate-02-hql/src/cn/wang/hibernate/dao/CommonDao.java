package cn.wang.hibernate.dao;

import java.util.List;

public interface CommonDao<T> {
	public List<T> getAllEntry();
	
	public Long getCount();
}
