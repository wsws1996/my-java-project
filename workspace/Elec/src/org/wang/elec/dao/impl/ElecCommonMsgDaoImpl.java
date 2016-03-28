package org.wang.elec.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.domain.ElecSystemDDL;

@Repository(IElecSystemDDLDao.SERVICE_NAME)
public class ElecCommonMsgDaoImpl extends CommonDaoImpl<ElecSystemDDL>
		implements IElecSystemDDLDao {
	/**
	 * @name:findSystemDDLByDistinct
	 * @description:数据字典的首页显示,去掉重复值
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-28
	 * @param: 无
	 * @return List<ElecSystemDDL> 存放数据类型的集合
	 */
	@Override
	public List<ElecSystemDDL> findSystemDDLByDistinct() {
		List<ElecSystemDDL> systemList = new ArrayList<ElecSystemDDL>();
		// String hql = "SELECT DISTINCT o.keyword" + " FROM ElecSystemDDL o";
		// List<Object> list = this.getHibernateTemplate().find(hql);
		// if (list!=null&&list.size()>0) {
		// for (Object object : list) {
		// ElecSystemDDL elecSystemDDL=new ElecSystemDDL();
		// elecSystemDDL.setKeyword(object.toString());
		// systemList.add(elecSystemDDL);
		// }
		// }

		String hql = "SELECT DISTINCT new org.wang.elec.domain.ElecSystemDDL(o.keyword)"
				+ " FROM ElecSystemDDL o";
		systemList = this.getHibernateTemplate().find(hql);
		return systemList;
	}

}
