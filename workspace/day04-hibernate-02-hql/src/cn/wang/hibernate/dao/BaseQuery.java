package cn.wang.hibernate.dao;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseQuery {
	private int currentPage;
	private int pageSize;
	private Map<String, Object> keyValues=new HashMap<String, Object>();

	public Map<String, Object> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(Map<String, Object> keyValues) {
		this.keyValues = keyValues;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public abstract void buildWhere();
}
