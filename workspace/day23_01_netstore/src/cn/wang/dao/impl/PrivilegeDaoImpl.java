package cn.wang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.dao.PrivilegeDao;
import cn.wang.domain.Function;
import cn.wang.domain.Role;
import cn.wang.domain.User;
import cn.wang.util.DBCPUtil;

public class PrivilegeDaoImpl implements PrivilegeDao {
	private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public User find(String username, String password) {
		try {
			return queryRunner.query(
					"select * from users where username=? and password=?",
					new BeanHandler<User>(User.class), username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Role> findRolesByUser(User user) {
		if (user==null|| user.getId()==null) {
			throw new IllegalArgumentException("参数不全");
		}
		try {
			return queryRunner.query(
					"select r.* from roles r,user_role ur where r.id=ur.r_id and ur.u_id=?",
					new BeanListHandler<Role>(Role.class), user.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Function> findFunctionsByRole(Role role) {
		if (role==null|| role.getId()==null) {
			throw new IllegalArgumentException("参数不全");
		}
		try {
			return queryRunner.query(
					"select f.* from functions f,role_function rf where f.id=rf.f_id and rf.r_id=?",
					new BeanListHandler<Function>(Function.class), role.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
