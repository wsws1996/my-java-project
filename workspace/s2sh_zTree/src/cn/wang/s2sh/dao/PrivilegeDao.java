package cn.wang.s2sh.dao;

import java.util.List;

import cn.wang.s2sh.domain.Privilege;

public interface PrivilegeDao {
	public List<Privilege> getPrivilegeTree();
}
