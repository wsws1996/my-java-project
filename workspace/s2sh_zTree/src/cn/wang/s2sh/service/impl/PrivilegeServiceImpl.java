package cn.wang.s2sh.service.impl;

import java.util.List;


import cn.wang.s2sh.dao.PrivilegeDao;
import cn.wang.s2sh.domain.Privilege;
import cn.wang.s2sh.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {

	private PrivilegeDao privilegeDao;

	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}

	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	@Override
	public List<Privilege> getPrivilegeTree() {
		return this.privilegeDao.getPrivilegeTree();
	}

}
