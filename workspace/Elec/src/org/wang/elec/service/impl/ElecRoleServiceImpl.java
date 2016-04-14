package org.wang.elec.service.impl;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecPopedomDao;
import org.wang.elec.dao.IElecRoleDao;
import org.wang.elec.dao.IElecRolePopedomDao;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.domain.ElecPopedom;
import org.wang.elec.domain.ElecRole;
import org.wang.elec.domain.ElecRolePopedom;
import org.wang.elec.domain.ElecUser;
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

	/**
	 * @name:findAllUserListByRoleID
	 * @description:使用当前角色ID，查询系统中所有的用户，并显示（匹配）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-05
	 * @param: 无
	 * @return List<ElecUser> 用户集合
	 */

	@Override
	public List<ElecUser> findAllUserListByRoleID(String roleID) {
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.onDutyDate", "asc");
		List<ElecUser> list = elecUserDao.findCollectionByConditionNoPage("",
				null, orderby);
		ElecRole elecRole = elecRoleDao.findObjectByID(roleID);
		Set<ElecUser> elecUsers = elecRole.getElecUsers();
		// 方案一（性能较高）
		// List<String> idList = new ArrayList<String>();
		// if (elecUsers != null && elecUsers.size() > 0) {
		// for (ElecUser elecUser : elecUsers) {
		// String userID = elecUser.getUserID();
		// idList.add(userID);
		// }
		// }
		// if (list != null && list.size() > 0) {
		// for (ElecUser elecUser : list) {
		// String userID = elecUser.getUserID();
		// if (idList.contains(userID)) {
		// elecUser.setFlag("1");
		// } else {
		// elecUser.setFlag("2");
		// }
		// }
		// }
		// 方案二（性能较低）
		if (list != null && list.size() > 0) {
			for (ElecUser elecUser : list) {
				String userID = elecUser.getUserID();
				if (elecUsers != null && elecUsers.size() > 0) {
					for (ElecUser elecUser2 : elecUsers) {
						String userID2 = elecUser2.getUserID();
						if (userID.equals(userID2)) {
							elecUser.setFlag("1");
							break;
						} else {
							elecUser.setFlag("2");
						}
					}
				}
			}
		}
		return list;
	}

	/**
	 * @name:saveRole
	 * @description:保存用户角色关联表，保存角色权限关联表
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-12
	 * @param: ElecPopedom VO对象
	 * @return 无
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveRole(ElecPopedom elecPopedom) {
		String roleID = elecPopedom.getRoleID();
		String[] selectopers = elecPopedom.getSelectoper();
		String[] selectusers = elecPopedom.getSelectuser();
		this.saveRolePopedom(roleID, selectopers);
		this.saveUserRole(roleID, selectusers);
	}

	// 操作用户角色关联表
	private void saveUserRole(String roleID, String[] selectusers) {
		ElecRole elecRole = elecRoleDao.findObjectByID(roleID);
		/* 方案一 */
		// Set<ElecUser> elecUsers = elecRole.getElecUsers();
		// elecUsers.clear();
		// if (selectusers != null && selectusers.length > 0) {
		// for (String userID : selectusers) {
		// ElecUser elecUser = new ElecUser();
		// elecUser.setUserID(userID);
		// elecUsers.add(elecUser);
		// }
		// }
		/* 方案二 */
		Set<ElecUser> elecUsers = new HashSet<ElecUser>();
		if (selectusers != null && selectusers.length > 0) {
			for (String userID : selectusers) {
				ElecUser elecUser = new ElecUser();
				elecUser.setUserID(userID);
				elecUsers.add(elecUser);
			}
		}
		elecRole.setElecUsers(elecUsers);
	}

	// 操作角色权限关联表
	private void saveRolePopedom(String roleID, String[] selectopers) {
		String condition = " and o.roleID=?";
		Object[] params = { roleID };
		List<ElecRolePopedom> list = elecRolePopedomDao
				.findCollectionByConditionNoPage(condition, params, null);
		elecRolePopedomDao.deleteObjectByCollection(list);
		if (selectopers != null && selectopers.length > 0) {
			for (String ids : selectopers) {
				String[] arrays = ids.split("_");
				ElecRolePopedom elecRolePopedom = new ElecRolePopedom();
				elecRolePopedom.setRoleID(roleID);
				elecRolePopedom.setPid(arrays[0]);
				elecRolePopedom.setMid(arrays[1]);
				elecRolePopedomDao.save(elecRolePopedom);
			}
		}
	}

	/**
	 * @name:findPopedomByRoleIDs
	 * @description:使用角色ID的HashTable的集合，获取角色对应的权限并集
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-13
	 * @param: HashTable：角色ID的集合
	 * @return String：表示权限的字符串（格式为aa@bb@cc）
	 */

	@Override
	public String findPopedomByRoleIDs(Hashtable<String, String> ht) {
		StringBuffer buffercondition = new StringBuffer();
		if (ht != null && ht.size() > 0) {
			for (Iterator<Entry<String, String>> ite = ht.entrySet().iterator(); ite
					.hasNext();) {
				Entry<String, String> entry = (Entry<String, String>) ite
						.next();
				buffercondition.append("'").append(entry.getKey()).append("'")
						.append(",");

			}
			buffercondition.deleteCharAt(buffercondition.length() - 1);
		}
		String condition = buffercondition.toString();
		List<Object> list = elecRolePopedomDao.findPopedomByRoleIDs(condition);
		StringBuffer buffer = new StringBuffer();
		if (list != null && list.size() > 0) {
			for (Object o : list) {
				buffer.append(o.toString()).append("@");
			}
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}

	/**
	 * @name:findPopedomListByString
	 * @description:使用权限的字符串，查询当前权限（当前用户）对应的权限集合
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-14
	 * @param: String：表示权限的字符串（格式为aa@bb@cc）
	 * @return List<ElecPopedom>：权限的集合 SELECT * FROM Elec_Popedom o WHERE 1 = 1
	 *         AND o.isMenu = TRUE AND o.mid in('aa','ab','ac');
	 */

	@Override
	public List<ElecPopedom> findPopedomListByString(String popedom) {
		String condition = " and o.isMenu = ? and o.mid in ('"
				+ popedom.replace("@", "','") + "')";
		Object[] params = { true };
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.mid", "asc");
		List<ElecPopedom> list = elecPopedomDao
				.findCollectionByConditionNoPage(condition, params, orderby);
		return list;
	}
}
