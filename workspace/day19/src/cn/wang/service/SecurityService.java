package cn.wang.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.wang.dao.PrivilegeDao;
import cn.wang.dao.RoleDao;
import cn.wang.dao.UserDao;
import cn.wang.domain.Privilege;
import cn.wang.domain.Role;
import cn.wang.domain.User;

public class SecurityService {

	private PrivilegeDao privilegeDao = new PrivilegeDao();
	private RoleDao roleDao = new RoleDao();
	private UserDao userDao = new UserDao();

	public void addPrivilege(Privilege privilege) {
		privilegeDao.add(privilege);
	}

	public Privilege findPrivilege(String id) {
		return privilegeDao.find(id);
	}

	public List<Privilege> getAllPrivilege() {
		return privilegeDao.getAll();
	}

	public void addRole(Role role) {
		roleDao.add(role);
	}

	public Role findRole(String id) {
		return roleDao.find(id);
	}

	public List<Privilege> getRolePrivileges(String role_id) {
		return roleDao.getRolePrivileges(role_id);
	}

	public List<Role> getAllRoles() {
		return roleDao.getAll();
	}

	public void updateRolePrivilege(String role_id, String[] privilege_ids) {
		Role role = roleDao.find(role_id);
		List<Privilege> privileges = new ArrayList<Privilege>();
		for (int i = 0; privilege_ids != null && i < privilege_ids.length; i++) {
			Privilege privilege = privilegeDao.find(privilege_ids[i]);
			privileges.add(privilege);
		}

		roleDao.updateRolePrivilege(role, privileges);
	}

	public void addUser(User user) {
		userDao.add(user);
	}

	public User findUser(String user_id) {
		return userDao.find(user_id);
	}

	public List<User> getAllUser() {
		return userDao.getAll();
	}

	public List<Role> getUserRoles(String user_id) {
		return userDao.getUserRoles(user_id);
	}

	public void updateUserRole(String user_id, String[] role_ids) {
		User user = userDao.find(user_id);
		List<Role> roles = new ArrayList<Role>();
		for (int i = 0; role_ids != null && i < role_ids.length; i++) {
			Role role = roleDao.find(role_ids[i]);
			roles.add(role);
		}
		userDao.updateUserRole(user, roles);
	}

	public Set<Privilege> getUserAllPrivileges(String user_id) {

		Set<Privilege> allPrivileges = new HashSet<Privilege>();

		List<Role> user_roles = userDao.getUserRoles(user_id);

		for (Role role : user_roles) {
			List<Privilege> privileges = roleDao
					.getRolePrivileges(role.getId());
			allPrivileges.addAll(privileges);
		}
		return allPrivileges;
	}

	public User login(String username, String password) {
		
		return userDao.find(username, password);
	}
}
