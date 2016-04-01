package org.wang.elec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.dao.IElecUserFileDao;
import org.wang.elec.domain.ElecUser;
import org.wang.elec.service.IElecUserService;

@Service(IElecUserService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecUserServiceImpl implements IElecUserService {

	@Resource(name = IElecUserDao.SERVICE_NAME)
	IElecUserDao elecUserDao;

	@Resource(name = IElecUserFileDao.SERVICE_NAME)
	IElecUserFileDao elecUserFileDao;

	@Resource(name = IElecSystemDDLDao.SERVICE_NAME)
	IElecSystemDDLDao elecSystemDDLDao;

	/**
	 * @name:findUserListByCondition
	 * @description:组织查询条件，查询用户列表
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-31
	 * @param: ElecUser VO对象
	 * @return: List<ElecUser>:用户集合
	 */

	@Override
	public List<ElecUser> findUserListByCondition(ElecUser elecUser) {

		String condition = "";
		List<Object> paramsList = new ArrayList<Object>();
		String userName = elecUser.getUserName();

		if (StringUtils.isNotBlank(userName)) {
			condition += "and o.userName like ?";
			paramsList.add("%" + userName + "%");
		}

		String jctID = elecUser.getJctID();

		if (StringUtils.isNotBlank(jctID)) {
			condition += "and o.jctID = ?";
			paramsList.add(jctID);
		}

		Date onDutyDateBegin = elecUser.getOnDutyDateBegin();

		if (onDutyDateBegin != null) {
			condition += "and o.onDutyDate >= ?";
			paramsList.add(onDutyDateBegin);
		}

		Date onDutyDateEnd = elecUser.getOnDutyDateEnd();

		if (onDutyDateEnd != null) {
			condition += "and o.onDutyDate <= ?";
			paramsList.add(onDutyDateEnd);
		}

		Object[] params = paramsList.toArray();

		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.onDutyDate", "asc");

		List<ElecUser> list = elecUserDao.findCollectionByConditionNoPage(
				condition, params, orderby);
		this.convertSystemDDL(list);
		return list;
	}

	private void convertSystemDDL(List<ElecUser> list) {
		if (list != null && list.size() > 0) {
			for (ElecUser user : list) {
				String sexID = elecSystemDDLDao
						.findDdlNameByKeywordAndDdlCode("性别", user.getSexID());
				user.setSexID(sexID);
				String postID=elecSystemDDLDao.findDdlNameByKeywordAndDdlCode("职位", user.getPostID());
				user.setPostID(postID);
			}
		}

	}

}
