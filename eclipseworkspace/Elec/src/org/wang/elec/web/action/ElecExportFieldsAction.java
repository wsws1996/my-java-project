package org.wang.elec.web.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecExportFields;
import org.wang.elec.service.IElecExportFieldsService;
import org.wang.elec.utils.ListUtils;

@SuppressWarnings("serial")
@Controller("elecExportFieldsAction")
@Scope(value = "prototype")
public class ElecExportFieldsAction extends BaseAction<ElecExportFields> {

	ElecExportFields elecExportFields = this.getModel();

	/**
	 * 注入导出设置service
	 */
	@Resource(name = IElecExportFieldsService.SERVICE_NAME)
	IElecExportFieldsService elecExportFieldsService;

	/**
	 * @name:setExportFields
	 * @description 跳转到导出设置的功能页面
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-20
	 * @param: 无
	 * @return String 跳转到system/exportExcel.jsp
	 */
	public String setExportFields() {
		String belongTo = elecExportFields.getBelongTo();
		ElecExportFields exportFields = elecExportFieldsService
				.findExportFieldByID(belongTo);
		Map<String, String> map = new LinkedHashMap<String, String>();
		Map<String, String> nomap = new LinkedHashMap<String, String>();
		List<String> zList = ListUtils.stringToList(
				exportFields.getExpNameList(), "#");
		List<String> eList = ListUtils.stringToList(
				exportFields.getExpFieldName(), "#");
		List<String> nozList = ListUtils.stringToList(
				exportFields.getNoExpNameList(), "#");
		List<String> noeList = ListUtils.stringToList(
				exportFields.getNoExpFieldName(), "#");

		if (zList != null && zList.size() > 0) {
			for (int i = 0; i < zList.size(); i++) {
				map.put(eList.get(i), zList.get(i));
			}
		}

		if (nozList != null && nozList.size() > 0) {
			for (int i = 0; i < nozList.size(); i++) {
				nomap.put(noeList.get(i), nozList.get(i));
			}
		}

		request.setAttribute("map", map);
		request.setAttribute("nomap", nomap);

		return "setExportFields";
	}

	/**
	 * @name:saveSetExportExcel
	 * @description:保存更新导出设置的配置
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-20
	 * @param: 无
	 * @return String 跳转到close.jsp（关闭子页面，刷新父页面）
	 */

	public String saveSetExportExcel() {
		elecExportFieldsService.saveSetExportExcel(elecExportFields);
		return "close";
	}
}
