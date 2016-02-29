package cn.wang.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.domain.Role;
import cn.wang.domain.User;
import cn.wang.utils.JdbcUtils;

public class UserDao {

	public void add(User user) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user(id,username,password) values(?,?,?)";
			Object params[] = { user.getId(), user.getUsername(),
					user.getPassword() };
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			return runner.query(sql, new BeanHandler<User>(User.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User find(String username, String password) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object params[] = { username, password };
			return runner.query(sql, new BeanHandler<User>(User.class), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user";
			return runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Role> getUserRoles(String user_id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select r.* from user_role ur,role r where ur.user_id=? and ur.role_id=r.id";
			return runner.query(sql, new BeanListHandler<Role>(Role.class),
					user_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateUserRole(User user, List<Role> roles) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete from user_role where user_id=?";
			runner.update(sql, user.getId());
			for (int i = 0; roles!=null && i < roles.size(); i++) {
				sql = "insert into user_role(user_id,role_id) values(?,?)";
				Object[] params = { user.getId(), roles.get(i).getId() };
				runner.update(sql, params);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
