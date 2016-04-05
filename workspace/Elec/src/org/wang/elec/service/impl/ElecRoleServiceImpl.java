package org.wang.elec.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecPopedomDao;
import org.wang.elec.dao.IElecRoleDao;
import org.wang.elec.dao.IElecRolePopedomDao;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.domain.ElecPopedom;
import org.wang.elec.domain.ElecRole;
import org.wang.elec.domain.ElecRolePopedom;
import org.wang.elec.service.IElecRoleService;

@Service(IElecRoleService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecRoleServiceImpl implements IElecRoleService {

	// 用户表Dao
	@Resource(name = IElecUserDao.SERVICE_NAME)
	IElecUserDao elecUserDao;

	// 角色表Dao
	@Resource(name = IElecRoleDao.SERVICE_NAME)
	IElecRoleDao elecRoleDao;

	// 权限表Dao
	@Resource(name = IElecPopedomDao.SERVICE_NAME)
	IElecPopedomDao elecPopedomDao;

	// 角色权限表Dao
	@Resource(name = IElecRolePopedomDao.SERVICE_NAME)
	IElecRolePopedomDao elecRolePopedomDao;

	/**
	 * @name:findAllRoleList
	 * @description:查询系统中所有的角色
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-05
	 * @param: 无
	 * @return List<ElecRole> 角色集合
	 */

	@Override
	public List<ElecRole> findAllRoleList() {
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.roleID", "asc");
		List<ElecRole> list = elecRoleDao.findCollectionByConditionNoPage("",
				null, orderby);
		return list;
	}

	/**
	 * @name:findAllPopedomList
	 * @description:查询系统中所有的权限（满足父中包含子的集合）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-05
	 * @param: 无
	 * @return List<ElecPopedom> 权限集合
	 */

	@Override
	public List<ElecPopedom> findAllPopedomList() {
		String condition = " and o.pid=?";
		Object[] params = { "0" };
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.mid", "asc");
		List<ElecPopedom> list = elecPopedomDao
				.findCollectionByConditionNoPage(condition, params, orderby);
		if (list != null && list.size() > 0) {
			for (ElecPopedom elecPopedom : list) {
				String mid = elecPopedom.getMid();
				String condition1 = " and o.pid=?";
				Object[] params1 = { mid };
				Map<String, String> orderby1 = new LinkedHashMap<String, String>();
				orderby.put("o.mid", "asc");
				List<ElecPopedom> list1 = elecPopedomDao
						.findCollectionByConditionNoPage(condition1, params1,
								orderby1);
				elecPopedom.setList(list1);
			}
		}
		return list;
	}

	/**
	 * @name:findAllPopedomListByRoleID
	 * @description:使用当前角色ID，查询系统中所有的权限，并显示（匹配）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-05
	 * @param: 无
	 * @return List<ElecPopedom> 权限集合
	 */

	@Override
	public List<ElecPopedom> findAllPopedomListByRoleID(String roleID) {
		List<ElecPopedom> list = this.findAllPopedomList();

		String condition = " and o.roleID=?";
		Object[] params = { roleID };

		List<ElecRolePopedom> popedomList = elecRolePopedomDao
				.findCollectionByConditionNoPage(condition, params, null);
		StringBuffer popedomBuffer = new StringBuffer("");
		if (popedomList != null && popedomList.size() > 0) {
			for (ElecRolePopedom elecRolePopedom : popedomList) {
				String mid = elecRolePopedom.getMid();
				popedomBuffer.append(mid).append("@");
			}
			popedomBuffer.deleteCharAt(popedomBuffer.length() - 1);
		}
		String popedom = popedomBuffer.toString();
		this.findPopedomResult(popedom, list);
		return list;
	}

	private void findPopedomResult(String popedom, List<ElecPopedom> list) {
		if (list != null && list.size() > 0) {
			for (ElecPopedom elecPopedom : list) {
				String mid = elecPopedom.getMid();
				if (popedom.contains(mid)) {
					elecPopedom.setFlag("1");
				} else {
					elecPopedom.setFlag("2");
				}
				List<ElecPopedom> childList = elecPopedom.getList();
				if (childList != null && childList.size() > 0) {
					this.findPopedomResult(popedom, childList);
				}
			}
		}
	}
}
