package org.wang.elec.web.action;

import java.io.IOException;
import java.io.PrintWriter;

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
		// 模拟保存150次，方便计算百分比
		for (int i = 1; i <= 150; i++) {
			elecCommonMsgService.saveCommonMsg(elecCommonMsg);
			request.getSession()
					.setAttribute("percent", (double) i / 150 * 100);// 存放计算的百分比，此处使用session，因为session可以在一个会话中共享数据，使得在progressBar方法（线程）中可以获取percent的数据
		}
		// 线程结束时，清空当前session
		request.getSession().removeAttribute("percent");
		return "save";
	}

	/**
	 * @name:actingView
	 * @description:使用highsliderjs完成查询设备运行情况的详细信息
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-28
	 * @param: 无
	 * @return String 跳转到system/actingView.jsp
	 */

	public String actingView() {

		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		ValueUtils.putValueStack(commonMsg);
		return "actingView";
	}

	/**
	 * @name:processBar
	 * @description:在页面执行保存后，使用ajax，计算执行的百分比，将结果显示到页面上
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-31
	 * @param: 无
	 * @return ajax如果不需要跳转页面，返回null或none
	 * @throws IOException
	 */

	public String progressBar() throws IOException {
		// 从session中获取操作方法中计算的百分比
		Double percent = (Double) request.getSession().getAttribute("percent");
		String res = "";
		// 此时说明操作的业务方法仍然继续在执行
		if (percent != null) {
			// 计算的小数，四舍五入取整
			int percentInt = (int) Math.rint(percent);
			res = "<percent>" + percentInt + "</percent>";
		}
		// 此时说明操作的业务方法已经执行完毕，session中的值已经被清空
		else {
			// 存放百分比
			res = "<percent>" + 100 + "</percent>";
		}
		// 定义ajax的返回结果是XML的形式
		PrintWriter out = response.getWriter();
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		// 存放结果数据，例如：<response><percent>88</percent></response>
		out.println("<response>");
		out.println(res);
		out.println("</response>");
		out.close();
		return null;
	}
}
