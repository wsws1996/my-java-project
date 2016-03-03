package cn.wang.hibernate.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao<T> {
	public List<T> getAllEntry();
	
	public PageResult<T> getPageResult(BaseQuery baseQuery);
	
	public List<T> getEntriesByCondition(Map<String, Object> keyValues);
	
	public Long getCount();
}
