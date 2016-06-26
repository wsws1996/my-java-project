package org.wang.elec.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.wang.elec.utils.PageInfo;


public interface ICommonDao<T> {
	void save(T entity);

	void update(T eneity);

	T findObjectByID(Serializable id);

	void deleteObjectByIds(Serializable... ids);

	void deleteObjectByCollection(List<T> list);

	List<T> findCollectionByConditionNoPage(String condition, Object[] params,
			Map<String, String> orderby);

	List<T> findCollectionByConditionNoPageWithCache(String condition,
			Object[] params, Map<String, String> orderby);

	List<T> findCollectionByConditionWithPage(String condition,
			Object[] params, Map<String, String> orderby, PageInfo pageInfo);

	@SuppressWarnings("rawtypes")
	List findCollectionByConditionNoPageWithSelectCondition(String condition,
			Object[] params, Map<String, String> orderby, String selectCondition);

	void saveList(List<T> list);
}
