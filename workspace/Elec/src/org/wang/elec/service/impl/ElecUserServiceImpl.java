package org.wang.elec.service.impl;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecExportFieldsDao;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.dao.IElecUserFileDao;
import org.wang.elec.domain.ElecExportFields;
import org.wang.elec.domain.ElecRole;
import org.wang.elec.domain.ElecUser;
import org.wang.elec.domain.ElecUserFile;
import org.wang.elec.service.IElecUserService;
import org.wang.elec.utils.FileUtils;
import org.wang.elec.utils.ListUtils;
import org.wang.elec.utils.MD5keyBean;
import org.wang.elec.utils.PageInfo;

@Service(IElecUserService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecUserServiceImpl implements IElecUserService {

	@Resource(name = IElecUserDao.SERVICE_NAME)
	IElecUserDao elecUserDao;

	@Resource(name = IElecUserFileDao.SERVICE_NAME)
	IElecUserFileDao elecUserFileDao;

	@Resource(name = IElecSystemDDLDao.SERVICE_NAME)
	IElecSystemDDLDao elecSystemDDLDao;

	@Resource(name = IElecExportFieldsDao.SERVICE_NAME)
	IElecExportFieldsDao elecExportFieldDao;

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
		/** 方案一：查询用户表，再转换数据字典表 */
		// List<ElecUser> list = elecUserDao.findCollectionByConditionNoPage(
		// condition, params, orderby);
		/** 2016-04-25,添加分页 begin */
		PageInfo pageInfo = new PageInfo(ServletActionContext.getRequest());
		List<ElecUser> list = elecUserDao.findCollectionByConditionWithPage(
				condition, params, orderby, pageInfo);
		ServletActionContext.getRequest().setAttribute("page",
				pageInfo.getPageBean());
		/** 2016-04-25,添加分页 end */
		this.convertSystemDDL(list);
		/** 直接使用sql */
		// List<ElecUser> list =
		// elecUserDao.findCollectionByConditionNoPageWithSql(
		// condition, params, orderby);
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
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveUser(ElecUser elecUser) {
		this.saveUserFiles(elecUser);
		this.md5password(elecUser);
		String userID = elecUser.getUserID();
		if (StringUtils.isNotBlank(userID)) {
			// 组织PO对象，执行更新（1条）
			elecUserDao.update(elecUser);
		} else {
			// 组织PO对象，保存用户（1条数据）
			elecUserDao.save(elecUser);
		}
	}

	private void md5password(ElecUser elecUser) {
		String logonPwd = elecUser.getLogonPwd();
		String md5password = "";

		if (StringUtils.isBlank(logonPwd)) {
			logonPwd = "123";
		}

		// 编辑如果没有修改密码，不需要加密
		String password = elecUser.getPassword();
		if (password != null && password.equals(logonPwd)) {
			md5password = logonPwd;
		} else {
			MD5keyBean md5keyBean = new MD5keyBean();
			md5password = md5keyBean.getkeyBeanofStr(logonPwd);
			elecUser.setLogonPwd(md5password);
		}
	}

	private void saveUserFiles(ElecUser elecUser) {
		Date progressTime = new Date();
		File[] uploads = elecUser.getUploads();
		String[] fileNames = elecUser.getUploadsFileName();
		// String[] contentTypes = elecUser.getUploadsContentType();

		if (uploads != null && uploads.length > 0) {
			for (int i = 0; i < uploads.length; i++) {
				ElecUserFile elecUserFile = new ElecUserFile();
				elecUserFile.setFileName(fileNames[i]);
				elecUserFile.setProgressTime(progressTime);
				String fileURL = FileUtils.fileUploadReturnPath(uploads[i],
						fileNames[i], "用户管理");
				elecUserFile.setFileURL(fileURL);
				elecUserFile.setElecUser(elecUser);
				elecUserFileDao.save(elecUserFile);
			}
		}
	}

	/**
	 * @name:findUserByID
	 * @description:使用用户ID，查询用户对象
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-02
	 * @param: String:用户ID
	 * @return: ElecUser:用户信息
	 */
	@Override
	public ElecUser findUserByID(String userID) {
		return elecUserDao.findObjectByID(userID);
	}

	/**
	 * @name:findUserFileByID
	 * @description:使用用户附件ID，查询用户对象
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-02
	 * @param: String:用户附件ID
	 * @return: ElecUser:用户附件信息
	 */

	@Override
	public ElecUserFile findUserFileByID(String fileID) {
		return elecUserFileDao.findObjectByID(fileID);
	}

	/**
	 * @name:deleteUserByID
	 * @description:删除用户信息
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-04
	 * @param: ElecUser:VO对象
	 * @return: 无
	 */

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteUserByID(ElecUser elecUser) {
		String userID = elecUser.getUserID();
		String[] userIDs = userID.split(", ");
		if (userIDs != null && userIDs.length > 0) {
			for (String uid : userIDs) {
				ElecUser user = elecUserDao.findObjectByID(uid);
				Set<ElecUserFile> elecUserFiles = user.getElecUserFiles();
				if (elecUserFiles != null && elecUserFiles.size() > 0) {
					for (ElecUserFile elecUserFile : elecUserFiles) {
						String path = ServletActionContext.getServletContext()
								.getRealPath("") + elecUserFile.getFileURL();
						File file = new File(path);
						if (file.exists()) {
							file.delete();
						}
						// 在循环中删除文件记录
						// elecUserFileDao.deleteObjectByIds(elecUserFile.getFileID());
					}
				}
				/* 2016年04月13日15:56:45添加，同时删除用户角色关联的数据begin */
				// user.getElecRoles().clear();
				// 因为user没有控制中间表的权限（inverse=true），所以此方法不可行
				Set<ElecRole> elecRoles = user.getElecRoles();
				if (elecRoles != null && elecRoles.size() > 0) {
					for (ElecRole elecRole : elecRoles) {
						elecRole.getElecUsers().remove(user);
					}
				}
				/* 2016年04月13日15:56:45添加，同时删除用户角色关联的数据end */
			}
		}
		// 删除用户表的信息，并级联删除用户文件表信息，基于cascade="delete"
		elecUserDao.deleteObjectByIds((Serializable[]) userIDs);
	}

	/**
	 * @name:findUserByLogonName
	 * @description:使用登录名作为查询条件，查询登录名对应的登录信息
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-13
	 * @param: String：登录名
	 * @return: ElecUser:用户对象
	 */
	@Override
	public ElecUser findUserByLogonName(String name) {
		String condition = "";
		List<Object> paramsList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(name)) {
			condition += " and  o.logonName=?";
			paramsList.add(name);
		}
		Object[] params = paramsList.toArray();
		List<ElecUser> list = elecUserDao.findCollectionByConditionNoPage(
				condition, params, null);
		ElecUser elecUser = null;
		if (list != null && list.size() > 0) {
			elecUser = list.get(0);
		}
		return elecUser;
	}

	@Override
	/**
	 * @name findFieldNameWithExcel
	 * @description 获取excel上的标题字段，通过导出设置表（动态导出）
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月26日
	 * @return ArrayList<String> excel上的标题
	 */
	public ArrayList<String> findFieldNameWithExcel() {
		ElecExportFields elecExportFields = elecExportFieldDao
				.findObjectByID("5-1");
		String zName = elecExportFields.getExpNameList();
		ArrayList<String> fieldName = (ArrayList<String>) ListUtils
				.stringToList(zName, "#");
		return fieldName;
	}

	@Override
	/**
	 * 
	 * @name findFieldDataWithExcel
	 * @description 获取excel的数据字段，通过导出设置表导出（动态导出）
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月26日
	 * @param elecUser
	 * @return ArrayList<ArrayList<String>> excel的内容
	 */
	public ArrayList<ArrayList<String>> findFieldDataWithExcel(ElecUser elecUser) {
		ArrayList<ArrayList<String>> fieldData = new ArrayList<ArrayList<String>>();
		// 组织投影查询的条件，（从导出设置表的英文字段获取）
		ElecExportFields elecExportFields = elecExportFieldDao
				.findObjectByID("5-1");
		String zName = elecExportFields.getExpNameList();
		List<String> zList = ListUtils.stringToList(zName, "#");
		String eName = elecExportFields.getExpFieldName();
		String selectCondition = eName.replace("#", ",");
		/*******************************/
		// 组织查询条件
		String condition = "";
		List<Object> paramsList = new ArrayList<Object>();
		String userName = elecUser.getUserName();
		
		try {
			userName=URLDecoder.decode(userName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
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
		// 查询数据结果
		@SuppressWarnings("rawtypes")
		List list = elecUserDao
				.findCollectionByConditionNoPageWithSelectCondition(condition,
						params, orderby, selectCondition);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] arrays = null;
				if (selectCondition.contains(",")) {
					arrays = (Object[]) list.get(i);
				} else {
					arrays = new Object[1];
					arrays[0] = list.get(i);
				}
				ArrayList<String> data = new ArrayList<String>();
				if (arrays != null && arrays.length > 0) {
					for (int j = 0; j < arrays.length; j++) {
						Object o = arrays[j];
						if (zList != null && zList.get(j).equals("性别")
								|| zList.get(j).equals("所属单位")
								|| zList.get(j).equals("是否在职")
								|| zList.get(j).equals("职位")) {
							data.add(o != null ? elecSystemDDLDao
									.findDdlNameByKeywordAndDdlCode(
											zList.get(j), o.toString()) : "");
						} else {
							data.add(o != null ? o.toString() : "");
						}
					}
				}
				fieldData.add(data);
			}
		}
		return fieldData;
	}

	@Override
	/**
	 * @name saveUserList
	 * @description 保存一个用户的集合
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月27日
	 * @param userList 用户集合
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUserList(List<ElecUser> userList) {
		elecUserDao.saveList(userList);
	}

	@Override
	/**
	 * @name chartUser
	 * @description 统计用户分配情况
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月28日
	 * @param zName 传递的数据类型
	 * @param eName 字段名称
	 * @return List<Object[]> 数据集合
	 */
	public List<Object[]> chartUser(String zName, String eName) {
		return elecUserDao.chartUser(zName,eName);
	}

}
