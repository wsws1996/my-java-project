package org.wang.elec.web.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.domain.ElecUser;
import org.wang.elec.domain.ElecUserFile;
import org.wang.elec.service.IElecSystemDDLService;
import org.wang.elec.service.IElecUserService;
import org.wang.elec.utils.ChartUtils;
import org.wang.elec.utils.DateUtils;
import org.wang.elec.utils.ExcelFileGenerator;
import org.wang.elec.utils.GenerateSqlFromExcel;
import org.wang.elec.utils.MD5keyBean;
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
		/** 2016-04-25,添加分页 begin */
		String initpage = request.getParameter("initpage");
		if (initpage != null && initpage.equals("1")) {
			return "list";
		}
		/** 2016-04-25,添加分页 end */
		/* 故意抛出异常，测试日志记录及异常处理，发布时应该删除 */
		// try {
		// int i =1/0;
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new RuntimeException("抛出运行时异常，在用户action中的home方法");
		// }

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
		String roleflag = elecUser.getRoleflag();
		if (roleflag != null && roleflag.equals("1")) {
			return "redirectEdit";
		}
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
		user.setRoleflag(elecUser.getRoleflag());
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
		/** 添加执行删除后定向到当前页 */
		request.setAttribute("pageNO", request.getParameter("pageNO"));
		return "delete";
	}

	// /**
	// * @name exportExcel
	// * @description 将数据通过查询条件，导出对应数据的excel报表
	// * @author wang
	// * @version V1.00
	// * @createDate 2016年4月26日
	// * @return 不使用struts2开发，导出
	// * @throws Exception
	// */
	// public String exportExcel() throws Exception {
	// ArrayList<String> fieldName = elecUserService.findFieldNameWithExcel();
	// ArrayList<ArrayList<String>> fieldData = elecUserService
	// .findFieldDataWithExcel(elecUser);
	// ExcelFileGenerator excelFileGenerator = new ExcelFileGenerator(
	// fieldName, fieldData);
	// String filename = "用户报表(" + DateUtils.dateToStringWithExcel(new Date())
	// + ").xls";
	// //处理乱码
	// filename=new String(filename.getBytes("utf-8"), "iso8859-1");
	// response.setContentType("application/vnd.ms-excel");
	// response.setHeader("Content-disposition", "attachment;filename="
	// + filename);
	// response.setBufferSize(1024);
	// OutputStream os = response.getOutputStream();
	// excelFileGenerator.expordExcel(os);
	// return null;
	// }

	/**
	 * @name exportExcel
	 * @description 将数据通过查询条件，导出对应数据的excel报表
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月26日
	 * @return 使用struts2开发，导出
	 * @throws Exception
	 */
	public String exportExcel() throws Exception {
		ArrayList<String> fieldName = elecUserService.findFieldNameWithExcel();
		ArrayList<ArrayList<String>> fieldData = elecUserService
				.findFieldDataWithExcel(elecUser);
		ExcelFileGenerator excelFileGenerator = new ExcelFileGenerator(
				fieldName, fieldData);
		String filename = "用户报表(" + DateUtils.dateToStringWithExcel(new Date())
				+ ").xls";
		// 处理乱码
		filename = new String(filename.getBytes("utf-8"), "iso8859-1");
		request.setAttribute("filename", filename);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		excelFileGenerator.expordExcel(os);
		byte[] buf = os.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		elecUser.setInputStream(in);
		return "exportExcel";
	}

	/**
	 * @name importPage
	 * @description 跳转到导入页面
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月27日
	 * @return 跳转到system/userImport.jsp
	 */
	public String importPage() {
		return "importPage";
	}

	/**
	 * @name importData
	 * @description excel的数据导入
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月27日
	 * @return 跳转到system/userImport.jsp
	 * @throws Exception
	 */
	public String importData() throws Exception {

		File formFile = elecUser.getFile();
		GenerateSqlFromExcel fromExcel = new GenerateSqlFromExcel();
		ArrayList<String[]> arrayList = fromExcel.generateUserSql(formFile);
		List<String> errorList = new ArrayList<String>();

		List<ElecUser> userList = this.fromExcelListToPOList(arrayList,
				errorList);
		if (errorList != null && errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
		} else {
			elecUserService.saveUserList(userList);
		}
		return "importPage";
	}

	private List<ElecUser> fromExcelListToPOList(ArrayList<String[]> arrayList,
			List<String> errorList) throws ParseException {
		List<ElecUser> userList = new ArrayList<ElecUser>();
		if (arrayList != null && arrayList.size() > 0) {
			for (int i = 0; i < arrayList.size(); i++) {
				// 模板字段： 登录名 密码 用户姓名 性别 所属单位 联系地址 是否在职 出生日期 职位
				String[] arrays = arrayList.get(i);
				ElecUser elecUser = new ElecUser();
				if (StringUtils.isNotBlank(arrays[0])) {
					String message = elecUserService.checkUser(arrays[0]);
					if (message != null && message.equals("3")) {
						elecUser.setLogonName(arrays[0]);
					} else {
						errorList.add("第" + (i + 2) + "行，第" + (0 + 1)
								+ "列，登录名在数据库中已经存在！");
					}

				} else {
					errorList.add("第" + (i + 2) + "行，第" + (0 + 1)
							+ "列，登录名不能为空！");
				}
				if (StringUtils.isNotBlank(arrays[1])) {
					MD5keyBean bean = new MD5keyBean();
					String logonPwd = bean.getkeyBeanofStr(arrays[1]);
					elecUser.setLogonPwd(logonPwd);
				}

				if (StringUtils.isNotBlank(arrays[2])) {
					elecUser.setUserName(arrays[2]);
				}
				if (StringUtils.isNotBlank(arrays[3])) {
					String ddlCode = elecSystemDDLService
							.findDdlCodeByKeywordAndDdlName("性别", arrays[3]);
					if (StringUtils.isNotBlank(ddlCode)) {
						elecUser.setSexID(ddlCode);
					} else {
						errorList.add("第" + (i + 2) + "行，第" + (3 + 1)
								+ "列，性别在数据字典转换中不存在！");
					}
				} else {
					errorList
							.add("第" + (i + 2) + "行，第" + (3 + 1) + "列，性别不能为空！");
				}
				if (StringUtils.isNotBlank(arrays[4])) {
					String ddlCode = elecSystemDDLService
							.findDdlCodeByKeywordAndDdlName("所属单位", arrays[4]);
					if (StringUtils.isNotBlank(ddlCode)) {
						elecUser.setJctID(ddlCode);
					} else {
						errorList.add("第" + (i + 2) + "行，第" + (4 + 1)
								+ "列，所属单位在数据字典转换中不存在！");
					}
				} else {
					errorList.add("第" + (i + 2) + "行，第" + (4 + 1)
							+ "列，所属单位不能为空！");
				}
				if (StringUtils.isNotBlank(arrays[5])) {
					elecUser.setAddress(arrays[5]);
				}
				if (StringUtils.isNotBlank(arrays[6])) {
					String ddlCode = elecSystemDDLService
							.findDdlCodeByKeywordAndDdlName("是否在职", arrays[6]);
					if (StringUtils.isNotBlank(ddlCode)) {
						elecUser.setIsDuty(ddlCode);
					} else {
						errorList.add("第" + (i + 2) + "行，第" + (6 + 1)
								+ "列，是否在职在数据字典转换中不存在！");
					}
				} else {
					errorList.add("第" + (i + 2) + "行，第" + (6 + 1)
							+ "列，是否在职不能为空！");
				}
				if (StringUtils.isNotBlank(arrays[7])) {
					Date birthday = DateUtils.stringToDate(arrays[7]);
					elecUser.setBirthday(birthday);
				}
				if (StringUtils.isNotBlank(arrays[8])) {
					String ddlCode = elecSystemDDLService
							.findDdlCodeByKeywordAndDdlName("职位", arrays[8]);
					if (StringUtils.isNotBlank(ddlCode)) {
						elecUser.setPostID(ddlCode);
					} else {
						errorList.add("第" + (i + 2) + "行，第" + (8 + 1)
								+ "列，职位在数据字典转换中不存在！");
					}
				} else {
					errorList
							.add("第" + (i + 2) + "行，第" + (8 + 1) + "列，职位不能为空！");
				}
				userList.add(elecUser);
			}

		}
		return userList;
	}
	
	/**
	 * @name chartUser
	 * @description 用户统计
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月28日
	 * @return 跳转到system/userReport.jsp
	 */
	public String chartUser() {
		
		List<Object []> list =elecUserService.chartUser("所属单位","jctID");
		String filename= ChartUtils.createBarChart(list);
		request.setAttribute("filename", filename);
		return "chartUser";
	}
	
	/**
	 * @name chartUserFCF
	 * @description 用户统计（按照性别）技术（FCF报表）
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月28日
	 * @return 跳转到system/userReportFCF.jsp
	 */
	public String chartUserFCF() {
		//查询数据库，获取图形需要数据集合
				List<Object[]> list = elecUserService.chartUser("性别","sexID");
				//组织XML的数据
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < list.size(); i++) {
						/**b.keyword,b.ddlName,COUNT(b.ddlCode)*/
					 /* m   b.ddlName,b.keyword "COUNT(b.ddlCode)*/
					
						Object[] objects = (Object[])list.get(i);
						if(i==0){//组织第一个值
							String x = "男女比例统计";
							String y = "unit";//存在FusionChart中的一个问题，Y轴的显示不支持中文，所以用英文代替
							builder.append("<graph caption='用户统计报表("+objects[1].toString()+")' xAxisName='"+x+"' bgColor='FFFFDD' yAxisName='"+y+"' showValues='1'  decimals='0' baseFontSize='18'  maxColWidth='60' showNames='1' decimalPrecision='0'> ");
						}
						builder.append("<set name='"+objects[0].toString()+"' value='"+objects[2].toString()+"' color='AFD8F8'/>");
					    if(i==list.size()-1){//组织最后一个值
					    	builder.append("</graph>");
					    }
				} 
				request.setAttribute("chart", builder);//request中存放XML格式的数据
		return "chartUserFCF";
	}
}
