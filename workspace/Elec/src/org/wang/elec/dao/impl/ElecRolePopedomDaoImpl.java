package org.wang.elec.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecRolePopedomDao;
import org.wang.elec.domain.ElecRolePopedom;

@Repository(IElecRolePopedomDao.SERVICE_NAME)
public class ElecRolePopedomDaoImpl extends CommonDaoImpl<ElecRolePopedom>
		implements IElecRolePopedomDao {

	/**
	 * @name:findPopedomByRoleIDs
	 * @description:使用角色ID的HashTable的集合，获取的当前角色ID条件，查询角色对应的权限并集
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-13
	 * @param: String：存放条件
	 * @return List<Object>：表示权限的字符串集合
	 */

	@Override
	public List<Object> findPopedomByRoleIDs(String condition) {

		String hql = "SELECT DISTINCT o.mid FROM ElecRolePopedom o WHERE 1 = 1 AND  o.roleID IN ("
				+ condition + ")";
		@SuppressWarnings("unchecked")
		List<Object> list = this.getHibernateTemplate().find(hql);
		return list;
	}

}
