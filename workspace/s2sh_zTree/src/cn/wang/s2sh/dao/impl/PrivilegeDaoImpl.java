package cn.wang.s2sh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.wang.s2sh.dao.PrivilegeDao;
import cn.wang.s2sh.domain.Privilege;

public class PrivilegeDaoImpl extends HibernateDaoSupport implements PrivilegeDao {

	@Override
	public List<Privilege> getPrivilegeTree() {
		
		return this.getHibernateTemplate().find("from Privilege");
	}

}
