package org.wang.elec.web.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecCommonMsg;
import org.wang.elec.domain.ElecPopedom;
import org.wang.elec.domain.ElecRole;
import org.wang.elec.domain.ElecUser;
import org.wang.elec.service.IElecCommonMsgService;
import org.wang.elec.service.IElecRoleService;
import org.wang.elec.service.IElecUserService;
import org.wang.elec.utils.LogonUtils;
import org.wang.elec.utils.MD5keyBean;
import org.wang.elec.utils.ValueUtils;
import org.wang.elec.web.form.MenuForm;

@SuppressWarnings("serial")
@Controller("elecMenuAction")
@Scope(value = "prototype")
public class ElecMenuAction extends BaseAction<MenuForm> {

	MenuForm menuForm = this.getModel();

	/**
	 * 注入运行监控service
	 */
	@Resource(name = IElecCommonMsgService.SERVICE_NAME)
	IElecCommonMsgService elecCommonMsgService;

	/**
	 * 注入用户service
	 */
	@Resource(name = IElecUserService.SERVICE_NAME)
	IElecUserService elecUserService;

	/**
	 * 注入角色service
	 */
	@Resource(name = IElecRoleService.SERVICE_NAME)
	IElecRoleService elecRoleService;

	/**
	 * @name:menuHome
	 * @description:跳转到系统登录的首页
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 跳转到menu/home.jsp
	 */
	public String menuHome() {
		String name = menuForm.getName();
		String password = menuForm.getPassword();

		boolean flag = LogonUtils.checkNumber(request);

		if (!flag) {
			this.addActionError("验证码输入有误！");
			return "logonError";
		}

		ElecUser elecUser = elecUserService.findUserByLogonName(name);
		if (elecUser == null) {
			this.addActionError("用户名输入有误！");
			return "logonError";
		}
		// 校验密码是否正确
		if (StringUtils.isBlank(password)) {
			this.addActionError("密码不能为空！");
			return "logonError";
		} else {
			MD5keyBean bean = new MD5keyBean();
			String md5password = bean.getkeyBeanofStr(password);
			if (!md5password.equals(elecUser.getLogonPwd())) {
				this.addActionError("密码输入有误！");
				return "logonError";
			}
		}
		/* 判断用户是否分配了角色，如果分配了角色，将角色的信息存放起来 */
		Hashtable<String, String> ht = new Hashtable<String, String>();
		Set<ElecRole> elecRoles = elecUser.getElecRoles();
		if (elecRoles == null || 0 == elecRoles.size()) {
			this.addActionError("当前用户没有分配角色，请与管理员联系！");
			return "logonError";
		}
		// 如果分配了角色，将角色的信息存放起来
		else {
			for (ElecRole elecRole : elecRoles) {
				ht.put(elecRole.getRoleID(), elecRole.getRoleName());
			}
		}
		// 判断用户对应的角色是否分配了权限，如果分配了权限，将权限的信息存放起来，存放为字符串（aa@bb@cc）
		String popedom = elecRoleService.findPopedomByRoleIDs(ht);
		if (StringUtils.isBlank(popedom)) {
			this.addActionError("当前用户具有的角色没有分配权限，请与管理员联系！");
			return "logonError";
		}
		LogonUtils.rememberMe(name, password, request, response);

		request.getSession().setAttribute("globle_user", elecUser);
		request.getSession().setAttribute("globle_role", ht);
		request.getSession().setAttribute("globle_popedom", popedom);

		return "menuHome";
	}

	/**
	 * 标题
	 */
	public String title() {
		return "title";
	}

	/**
	 * 菜单
	 */
	public String left() {
		return "left";
	}

	/**
	 * 框架大小改变
	 */
	public String change() {
		return "change";
	}

	/**
	 * @name:loading
	 * @description:功能页面的显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-28
	 * @param: 无
	 * @return String 跳转到menu/loading.jsp
	 */
	public String loading() {
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		ValueUtils.putValueStack(commonMsg);
		return "loading";
	}

	/**
	 * @name:logout
	 * @description:重新登录
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 重定向到index.jsp
	 */

	public String logout() {
		request.getSession().invalidate();
		return "logout";
	}

	/**
	 * @name:alermStation
	 * @description:显示站点运行情况
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 跳转到menu/alermStation.jsp
	 */
	public String alermStation() {
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		ValueUtils.putValueStack(commonMsg);
		return "alermStation";
	}

	/**
	 * @name:alermDevice
	 * @description:显示设备运行情况
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 跳转到menu/alermDevice.jsp
	 */
	public String alermDevice() {
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		ValueUtils.putValueStack(commonMsg);
		return "alermDevice";
	}

	/**
	 * @name:showMenu
	 * @description:使用ajax动态加载左侧的树形菜单
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-14
	 * @param: 无
	 * @return String showMenu，使用struts2提供的json插件包
	 */
	public String showMenu() {
		@SuppressWarnings("unchecked")
		Hashtable<String, String> ht = (Hashtable<String, String>) request
				.getSession().getAttribute("globle_role");
		ElecUser elecUser = (ElecUser) request.getSession().getAttribute(
				"globle_user");
		String popedom = (String) request.getSession().getAttribute(
				"globle_popedom");
		List<ElecPopedom> list = elecRoleService
				.findPopedomListByString(popedom);
		if (!ht.containsKey("1")) {
			if (list != null && list.size() > 0) {
				for (ElecPopedom elecPopedom : list) {
					String mid = elecPopedom.getMid();
					String pid = elecPopedom.getPid();
					if ("an".equals(mid) && "am".equals(pid)) {
						elecPopedom
								.setUrl("../system/elecUserAction_edit.do?userID="
										+ elecUser.getUserID()+"&roleflag=1");
					}
				}
			}
		}
		ValueUtils.putValueStack(list);
		return "showMenu";
	}
}
