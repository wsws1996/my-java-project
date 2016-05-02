package org.wang.elec.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.domain.ElecUser;

@Repository(IElecUserDao.SERVICE_NAME)
public class ElecUserDaoImpl extends CommonDaoImpl<ElecUser> implements
		IElecUserDao {

	@Override
	public List<ElecUser> findCollectionByConditionNoPageWithSql(
			String condition, final Object[] params, Map<String, String> orderby) {

		String sql = "SELECT o.userID, o.logonName, o.userName, a.ddlName, o.contactTel, o.onDutyDate, b.ddlName FROM Elec_User o "
				+ " INNER JOIN Elec_SystemDDL a  ON o.sexID = a.ddlCode AND a.keyword = '性别'"
				+ " INNER JOIN Elec_SystemDDL b  ON o.postID = b.ddlCode AND b.keyword = '职位'"
				+ " where 1=1 ";

		String orderbyCondiction = this.orderbySql(orderby);

		final String finalSql = sql + condition + orderbyCondiction;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final List<Object[]> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public List<Object[]> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(finalSql)
								.addScalar("o.userID").addScalar("o.logonName")
								.addScalar("o.userName").addScalar("a.ddlName")
								.addScalar("o.contactTel")
								.addScalar("o.onDutyDate")
								.addScalar("b.ddlName");
						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						return query.list();
					}
				});
		List<ElecUser> userList = new ArrayList<ElecUser>();
		if (list != null && list.size() > 0) {
			for (Object[] o : list) {
				ElecUser elecUser = new ElecUser();
				elecUser.setUserID(o[0].toString());
				elecUser.setLogonName(o[1].toString());
				elecUser.setUserName(o[2].toString());
				elecUser.setSexID(o[3].toString());
				elecUser.setContactTel(o[4].toString());
				elecUser.setOnDutyDate((Date) o[5]);
				elecUser.setPostID(o[6].toString());
				userList.add(elecUser);
			}

		}
		return userList;
	}

	private String orderbySql(Map<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			buffer.append(" ORDER BY ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(map.getKey() + " " + map.getValue() + ",");
			}
			buffer.deleteCharAt(buffer.length() - 1);

		}
		return buffer.toString();
	}

	/**
	 * @name chartUser
	 * @description 统计用户分配情况
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月28日
	 * @param zName
	 *            传递的数据类型
	 * @param eName
	 *            字段名称
	 * @return List<Object[]> 数据集合
	 */
	@Override
	public List<Object[]> chartUser(String zName, String eName) {
		final String sql = "SELECT b.ddlName,b.keyword,"
				+ "COUNT(b.ddlCode) FROM Elec_User a "
				+ "INNER JOIN Elec_SystemDDL b " 
				+ "on a."+eName+"=b.ddlCode and "
				+ "b.keyword='"+zName+"' and a.isDuty='1' "
				+ "GROUP BY b.ddlName,b.keyword "
				+ "ORDER BY COUNT(b.ddlCode) desc";
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Object []> list= this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public List<Object []> doInHibernate(Session session) throws HibernateException,
					SQLException {
				SQLQuery query= session.createSQLQuery(sql);
				return query.list();
			}
		});
		return list;
	}
}
