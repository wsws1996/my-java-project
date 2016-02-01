package cn.wang.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.domain.Privilege;
import cn.wang.domain.Role;
import cn.wang.utils.JdbcUtils;

public class RoleDao {

	public void add(Role role) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(id,name,description) values(?,?,?)";
			Object params[] = { role.getId(), role.getName(),
					role.getDescription() };
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Role find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role where id=?";
			return runner.query(sql, new BeanHandler<Role>(Role.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Privilege> getRolePrivileges(String role_id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select p.* from role_privilege rp, privilege p where role_id=? and rp.privilege_id=p.id";
			return runner.query(sql, new BeanListHandler<Privilege>(
					Privilege.class), role_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Role> getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			return runner.query(sql, new BeanListHandler<Role>(Role.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void updateRolePrivilege(Role role, List<Privilege> privileges) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

			String sql = "delete from role_privilege where role_id=?";
			runner.update(sql, role.getId());
			for (int i = 0; privileges != null && i < privileges.size(); i++) {
				sql = "insert into role_privilege(role_id,privilege_id) values(?,?)";
				Object params[] = { role.getId(), privileges.get(i).getId() };
				runner.update(sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
