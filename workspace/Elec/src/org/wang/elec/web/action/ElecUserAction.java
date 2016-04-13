package org.wang.elec.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.domain.ElecUser;
import org.wang.elec.domain.ElecUserFile;
import org.wang.elec.service.IElecSystemDDLService;
import org.wang.elec.service.IElecUserService;
import org.wang.elec.utils.ValueUtils;

@SuppressWarnings("serial")
@Controller("elecUserAction")
@Scope(value = "prototype")
public class ElecUserAction extends BaseAction<ElecUser> {

	ElecUser elecUser = this.getModel();

	/**
	 * 注入用户Service
	 */
	@Resource(name = IElecUserService.SERVICE_NAME)
	IElecUserService elecUserService;

	/**
	 * 注入数据字典Service
	 */
	@Resource(name = IElecSystemDDLService.SERVICE_NAME)
	IElecSystemDDLService elecSystemDDLService;

	/**
	 * @name:home
	 * @description:用户管理的首页显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-31
	 * @param: 无
	 * @return String 跳转到system/userIndex.jsp
	 */
	public String home() {
		List<ElecSystemDDL> jctList = elecSystemDDLService
				.findSystemDDLByKeyword("所属单位");
		request.setAttribute("jctList", jctList);
		List<ElecUser> userList = elecUserService
				.findUserListByCondition(elecUser);
		request.setAttribute("userList", userList);
		return "home";
	}

	/**
	 * @name:add
	 * @description:跳转到用户管理的新增页面显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-01
	 * @param: 无
	 * @return String 跳转到system/userAdd.jsp
	 */
	public String add() {
		// 加载数据字典，遍历性别，职位，所属单位，是否在职
		this.initSystemDDL();
		return "add";
	}

	private void initSystemDDL() {
		List<ElecSystemDDL> sexList = elecSystemDDLService
				.findSystemDDLByKeyword("性别");
		request.setAttribute("sexList", sexList);
		List<ElecSystemDDL> postList = elecSystemDDLService
				.findSystemDDLByKeyword("职位");
		request.setAttribute("postList", postList);
		List<ElecSystemDDL> jctList = elecSystemDDLService
				.findSystemDDLByKeyword("所属单位");
		request.setAttribute("jctList", jctList);
		List<ElecSystemDDL> isDutyList = elecSystemDDLService
				.findSystemDDLByKeyword("是否在职");
		request.setAttribute("isDutyList", isDutyList);
	}

	/**
	 * @name:findJctUnit
	 * @description:使用jquery的ajax完成二级联动，使用所属单位，关联单位名称
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-01
	 * @param: 无
	 * @return 使用struts2的json插件包
	 */

	public String findJctUnit() {
		String jstID = elecUser.getJctID();
		List<ElecSystemDDL> list = elecSystemDDLService
				.findSystemDDLByKeyword(jstID);
		ValueUtils.putValueStack(list);
		return "findJctUnit";
	}

	/**
	 * @name:checkUser
	 * @description:使用jquery的ajax完成登录名的后台校验
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-01
	 * @param: 无
	 * @return 使用struts2的json插件包
	 */
	public String checkUser() {
		String logonName = elecUser.getLogonName();
		String message = elecUserService.checkUser(logonName);
		elecUser.setMessage(message);
		// ValueUtils.putValueStack(message);
		return "checkUser";
	}

	/**
	 * @name:save
	 * @description:保存用户
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-01
	 * @param: 无
	 * @return 跳转到close.jsp
	 */

	public String save() {
		elecUserService.saveUser(elecUser);
		return "close";
	}

	/**
	 * @name:edit
	 * @description:跳转到编辑页面
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-02
	 * @param: 无
	 * @return 跳转到system/userEdit.jsp
	 */
	public String edit() {
		String userID = elecUser.getUserID();
		ElecUser user = elecUserService.findUserByID(userID);
		user.setViewflag(elecUser.getViewflag());
		ValueUtils.putValueStack(user);
		this.initSystemDDL();
		String ddlCode = user.getJctID();
		String ddlName = elecSystemDDLService.findDdlNameByKeywordAndDdlCode(
				"所属单位", ddlCode);
		List<ElecSystemDDL> jctUnitList = elecSystemDDLService
				.findSystemDDLByKeyword(ddlName);
		request.setAttribute("jctUnitList", jctUnitList);
		return "edit";
	}

	// /**
	// * @name:download
	// * @description:文件下载（普通方式）
	// * @author wang
	// * @version V1.0
	// * @create Date: 2016-04-02
	// * @param: 无
	// * @return 无
	// */
	// public String download() {
	// try {
	// String fileID = elecUser.getFileID();
	// ElecUserFile elecUserFile = elecUserService
	// .findUserFileByID(fileID);
	// String path = ServletActionContext.getServletContext().getRealPath(
	// "")
	// + elecUserFile.getFileURL();
	//
	// String filename = elecUserFile.getFileName();
	// filename = new String(filename.getBytes("UTF-8"), "iso8859-1");
	//
	// response.setHeader("Content-disposition", "attachment;filename="
	// + filename);
	//
	// InputStream in = new FileInputStream(new File(path));
	// OutputStream out = response.getOutputStream();
	// for (int b = -1; (b = in.read()) != -1;) {
	// out.write(b);
	// }
	// out.close();
	// in.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return NONE;
	// }
	/**
	 * @name:download
	 * @description:文件下载（struts2方式）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-02
	 * @param: 无
	 * @return struts2的结果类型
	 */
	public String download() {
		try {
			String fileID = elecUser.getFileID();
			ElecUserFile elecUserFile = elecUserService
					.findUserFileByID(fileID);
			String path = ServletActionContext.getServletContext().getRealPath(
					"")
					+ elecUserFile.getFileURL();

			String filename = elecUserFile.getFileName();
			filename = new String(filename.getBytes("UTF-8"), "iso8859-1");
			request.setAttribute("filename", filename);
			InputStream in = new FileInputStream(new File(path));
			elecUser.setInputStream(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "download";
	}
	
	/**
	 * @name:delete
	 * @description:删除用户信息
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-04
	 * @param: 无
	 * @return 重定向到system/userIndex.jsp
	 */
	
	public String delete() {
		elecUserService.deleteUserByID(elecUser);
		return "delete";
	}
}
