package cn.wang.dao;

import java.sql.SQLException;
import java.util.List;

import cn.wang.domain.Account;
import cn.wang.utils.BeanHandler;
import cn.wang.utils.BeanListHandler;
import cn.wang.utils.JdbcUtils;

public class AccountDao {
	public void add(Account account) throws SQLException {
		String sql = "insert into account(name,money) values(?,?)";
		Object params[] = { account.getName(), account.getMoney() };
		JdbcUtils.update(sql, params);
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from account where id=?";
		Object params[] = { id };
		JdbcUtils.update(sql, params);
	}

	public void update(Account account) throws SQLException {
		String sql = "update account set name=?,money=? where  id=?";
		Object params[] = { account.getName(), account.getMoney(),
				account.getId() };
		JdbcUtils.update(sql, params);
	}

	public Account find(int id) throws SQLException {
		String sql = "select * from  account where id=?";
		Object params[] = { id };
		return (Account) JdbcUtils.query(sql, params, new BeanHandler(
				Account.class));

	}

	@SuppressWarnings("rawtypes")
	public List getAll() throws SQLException {
		String sql = "select * from account";
		Object params[] = {};
		return (List) JdbcUtils.query(sql, params, new BeanListHandler(
				Account.class));
	}
}
