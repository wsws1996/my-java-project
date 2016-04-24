package org.wang.elec.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecFileUploadDao;
import org.wang.elec.domain.ElecFileUpload;

@Repository(IElecFileUploadDao.SERVICE_NAME)
public class ElecFileUploadDaoImpl extends CommonDaoImpl<ElecFileUpload>
		implements IElecFileUploadDao {

	/**
	 * @name findFileUploadListByCondition
	 * @description 通过选择所属单位和图纸类别的查询条件，查询对应单位和图纸下的文件上传列表，返回 List<ElecFileUpload>
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-23
	 * @param String
	 *            condition:查询条件 Object [] params:可变参数 Map<String,String>
	 *            orderby :排序
	 * @return List<ElecFileUpload> :资料图纸的集合
	 */

	@Override
	public List<ElecFileUpload> findFileUploadListByCondition(String condition,
			final Object[] params, Map<String, String> orderby) {

		String sql = "SELECT o.SeqID,a.ddlName,b.ddlName,o.FileName,o.FileURL,o.ProgressTime,o.comment FROM Elec_FileUpload o INNER JOIN Elec_SystemDDL a on o.ProjID = a.ddlCode and a.keyword='所属单位' INNER JOIN Elec_SystemDDL b on o.ProjID = b.ddlCode AND b.keyword='图纸类别' WHERE 1=1";

		String orderbyCondiction = this.orderbySql(orderby);

		final String finalSql = sql + condition + orderbyCondiction;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		final List<Object[]> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public List<Object[]> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(finalSql)
								.addScalar("o.SeqID").addScalar("a.ddlName")
								.addScalar("b.ddlName").addScalar("o.FileName")
								.addScalar("o.FileURL")
								.addScalar("o.ProgressTime")
								.addScalar("o.comment");

						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						return query.list();
					}
				});
		List<ElecFileUpload> fileUploadList = new ArrayList<ElecFileUpload>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] arrays = list.get(i);
				ElecFileUpload elecFileUpload = new ElecFileUpload();
				elecFileUpload.setSeqId(Integer.parseInt(arrays[0].toString()));
				elecFileUpload.setProjId(arrays[1].toString());
				elecFileUpload.setBelongTo(arrays[2].toString());
				elecFileUpload.setFileName(arrays[3].toString());
				elecFileUpload.setFileUrl(arrays[4].toString());
				elecFileUpload.setProgressTime(arrays[5].toString());
				elecFileUpload.setComment(arrays[6].toString());
				fileUploadList.add(elecFileUpload);
			}
		}

		return fileUploadList;
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

}
