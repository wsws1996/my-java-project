package org.wang.elec.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.domain.ElecSystemDDL;

@Repository(IElecSystemDDLDao.SERVICE_NAME)
public class ElecSystemDDLDaoImpl extends CommonDaoImpl<ElecSystemDDL>
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
	@SuppressWarnings("unchecked")
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

	/**
	 * @name:findDdlNameByKeywordAndDdlCode
	 * @description:使用数据类型和数据项的编号，获取数据项的值
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-31
	 * @param: 无
	 * @return String 数据项的值
	 */

	@Override
	public String findDdlNameByKeywordAndDdlCode(final String keyword,
			final String ddlCode) {
		final String hql = "select o.ddlName from ElecSystemDDL o where o.keyword=? and o.ddlCode=?";
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Object> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setParameter(0, keyword);
						query.setParameter(1, Integer.parseInt(ddlCode));
						return query.list();
					}
				});
		String ddlName = "";
		if (list!=null &&list.size()>0) {
			Object object=list.get(0);
			ddlName=object.toString();
		}
		return ddlName;
	}

}
