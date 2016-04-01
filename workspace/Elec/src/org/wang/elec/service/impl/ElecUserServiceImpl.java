package org.wang.elec.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.jsf.FacesContextUtils;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.dao.IElecUserFileDao;
import org.wang.elec.domain.ElecUser;
import org.wang.elec.domain.ElecUserFile;
import org.wang.elec.service.IElecUserService;
import org.wang.elec.utils.FileUtils;

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
				String sexID = elecSystemDDLDao.findDdlNameByKeywordAndDdlCode(
						"性别", user.getSexID());
				user.setSexID(sexID);
				String postID = elecSystemDDLDao
						.findDdlNameByKeywordAndDdlCode("职位", user.getPostID());
				user.setPostID(postID);
			}
		}

	}

	/**
	 * @name:checkUser
	 * @description:验证登录名是否存在
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-01
	 * @param: String 登录名
	 * @return: String 判断登录名是否重复，返回一个标识message属性 message=1:表示登录名为空，不可以保存
	 *          message=2:表示登录名在数据库中已经存在，不可以保存 message=3:表示登录名在数据库中不存在，可以保存
	 */

	@Override
	public String checkUser(String logonName) {
		String message = "";
		if (StringUtils.isNotBlank(logonName)) {
			String condition = " and o.logonName = ?";
			Object[] params = { logonName };
			List<ElecUser> list = elecUserDao.findCollectionByConditionNoPage(
					condition, params, null);
			if (list != null && list.size() > 0) {
				message = "2";
			} else {
				message = "3";
			}
		} else {
			message = "1";
		}
		return message;
	}

	/**
	 * @name:saveUser
	 * @description:保存用户的信息
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-01
	 * @param: ElecUser VO对象
	 * @return: 无
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void saveUser(ElecUser elecUser) {
		this.saveUserFiles(elecUser);
		elecUserDao.save(elecUser);
	}

	private void saveUserFiles(ElecUser elecUser) {
		Date progressTime = new Date();
		File[] uploads = elecUser.getUploads();
		String[] fileNames = elecUser.getUploadsFileName();
		String[] contentTypes = elecUser.getUploadsContentType();

		if (uploads != null && uploads.length > 0) {
			for (int i = 0; i < uploads.length; i++) {
				ElecUserFile elecUserFile = new ElecUserFile();
				elecUserFile.setFileName(fileNames[i]);
				elecUserFile.setProgressTime(progressTime);
				String fileURL=FileUtils.fileUploadReturnPath(uploads[i],fileNames[i],"用户管理");
				elecUserFile.setFileURL(fileURL);
				elecUserFile.setElecUser(elecUser);
				elecUserFileDao.save(elecUserFile);
			}
		}
	}

}
