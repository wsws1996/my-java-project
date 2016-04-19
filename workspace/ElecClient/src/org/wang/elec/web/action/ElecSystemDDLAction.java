package org.wang.elec.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.service.IElecSystemDDLService;
import org.wang.elec.utils.AnnotationLimit;

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
	@AnnotationLimit(mid = "aq", pid = "am")
	public String home() {
		List<ElecSystemDDL> list = elecSystemDDLService
				.findSystemDDLByDistinct();
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
	@AnnotationLimit(mid = "eb", pid = "ea")
	public String edit() {
		String keyword = elecSystemDDL.getKeyword();
		List<ElecSystemDDL> list = elecSystemDDLService
				.findSystemDDLByKeyword(keyword);
		request.setAttribute("list", list);
		return "edit";
	}

	/**
	 * @name:save
	 * @description:保存数据字典
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-30
	 * @param: 无
	 * @return String 重定向到system/dictionaryEdit.jsp
	 */
	@AnnotationLimit(mid = "ec", pid = "ea")
	public String save() {
		elecSystemDDLService.saveSystemDDL(elecSystemDDL);
		return "save";
	}
	/**用于分公司同步总部的数据字典数据，使用webservice技术*/
	 @AnnotationLimit(mid="ed",pid="ea")
	public String saveWebService() {
		elecSystemDDLService.saveWebService();
		return "save";
	}
}
