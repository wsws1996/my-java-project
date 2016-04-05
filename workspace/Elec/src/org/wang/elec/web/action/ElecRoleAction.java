package org.wang.elec.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecPopedom;
import org.wang.elec.domain.ElecRole;
import org.wang.elec.service.IElecRoleService;

@SuppressWarnings("serial")
@Controller("elecRoleAction")
@Scope(value = "prototype")
public class ElecRoleAction extends BaseAction<ElecPopedom> {

	ElecPopedom elecPopedom = this.getModel();

	/**
	 * 注入角色的service
	 */
	@Resource(name = IElecRoleService.SERVICE_NAME)
	IElecRoleService elecRoleService;

	/**
	 * @name:home
	 * @description:角色管理的首页显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-05
	 * @param: 无
	 * @return String 跳转到system/roleIndex.jsp
	 */
	public String home() {
		List<ElecRole> roleList = elecRoleService.findAllRoleList();
		request.setAttribute("roleList", roleList);
		List<ElecPopedom> popedomList=elecRoleService.findAllPopedomList();
		request.setAttribute("popedomList", popedomList);
		return "home";
	}
	
	/**
	 * @name:edit
	 * @description:跳转到编辑页面
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-05
	 * @param: 无
	 * @return String 跳转到system/roleEdit.jsp
	 */
	public String edit() {
		String roleID=elecPopedom.getRoleID();
		List<ElecPopedom> popedomList=elecRoleService.findAllPopedomListByRoleID(roleID);
		request.setAttribute("popedomList", popedomList);
		return "edit";
	}

}
