package cn.wang.dao;

import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.domain.Privilege;
import cn.wang.utils.JdbcUtils;

public class PrivilegeDao {
	public void add(Privilege privilege) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into privilege(id,name,description ) values(?,?,?)";
			Object params[] = { privilege.getId(), privilege.getName(),
					privilege.getDescription() };
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Privilege find(String id) {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege where id=?";
			return runner.query(sql,
					new BeanHandler<Privilege>(Privilege.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Privilege> getAll() {
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege";
			return runner.query(sql, new BeanListHandler<Privilege>(
					Privilege.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
