package org.wang.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecCommonMsg;
import org.wang.elec.service.IElecCommonMsgService;
import org.wang.elec.utils.ValueUtils;

@SuppressWarnings("serial")
@Controller("elecCommonMsgAction")
@Scope(value = "prototype")
public class ElecCommonMsgAction extends BaseAction<ElecCommonMsg> {

	ElecCommonMsg elecCommonMsg = this.getModel();

	/**
	 * 注入运行监控service
	 */
	@Resource(name = IElecCommonMsgService.SERVICE_NAME)
	IElecCommonMsgService elecCommonMsgService;

	/**
	 * @name:home
	 * @description:运行监控的首页显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 跳转到system/actingIndex.jsp
	 */
	public String home() {
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		ValueUtils.putValueStack(commonMsg);
		return "home";
	}

	/**
	 * @name:save
	 * @description:保存运行监控的数据
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return String 重定向到system/actingIndex.jsp
	 */

	public String save() {
		elecCommonMsgService.saveCommonMsg(elecCommonMsg);
		return "save";
	}
}
