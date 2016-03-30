package org.wang.elec.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.service.IElecSystemDDLService;

@SuppressWarnings("serial")
@Controller("elecSystemDDLAction")
@Scope(value = "prototype")
public class ElecSystemDDLAction extends BaseAction<ElecSystemDDL> {

	ElecSystemDDL elecSystemDDL = this.getModel();

	/**
	 * 注入运行监控service
	 */
	@Resource(name = IElecSystemDDLService.SERVICE_NAME)
	IElecSystemDDLService elecSystemDDLService;

	/**
	 * @name:home
	 * @description:数据字典的首页显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-28
	 * @param: 无
	 * @return String 跳转到system/dictionaryIndex.jsp
	 */
	public String home() {
		List<ElecSystemDDL> list=elecSystemDDLService.findSystemDDLByDistinct();
		request.setAttribute("list", list);
		return "home";
	}
	
	/**
	 * @name:edit
	 * @description:跳转到编辑数据字典的页面
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-29
	 * @param: 无
	 * @return String 跳转到system/dictionaryEdit.jsp
	 */
	
	public String edit() {
		String keyword=elecSystemDDL.getKeyword();
		System.out.println("keyword:"+keyword);
		return "edit";
	}
}
