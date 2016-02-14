package cn.wang.dao;

import java.util.List;

import cn.wang.domain.Function;
import cn.wang.domain.Role;
import cn.wang.domain.User;

public interface PrivilegeDao {

	User find(String username, String password);

	List<Role> findRolesByUser(User user);

	List<Function> findFunctionsByRole(Role role);

}
