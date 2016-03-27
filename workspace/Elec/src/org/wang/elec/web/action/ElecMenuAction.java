package org.wang.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecCommonMsg;
import org.wang.elec.domain.ElecText;
import org.wang.elec.service.IElecCommonMsgService;
import org.wang.elec.service.IElecTextService;
import org.wang.elec.utils.ValueUtils;
import org.wang.elec.web.form.MenuForm;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	 * @name:menuHome
	 * @description:跳转到系统登录的首页
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 跳转到menu/home.jsp
	 */
	public String menuHome() {
		System.out.println(menuForm.getName() + ":" + menuForm.getPassword());
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
	 * 功能区域显示页面
	 */
	public String loading() {
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
}
