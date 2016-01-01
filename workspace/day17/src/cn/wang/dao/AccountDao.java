package cn.wang.dao;

//import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.wang.domain.Account;
import cn.wang.utils.JdbcUtil;

public class AccountDao {
//	private Connection connection = null;
//
//	public AccountDao(Connection connection) {
//		this.connection = connection;
//	}

	public AccountDao() {
	}

	// dao层只负责增删改查，以下代码可以完成功能，但违反设计原则
	// public void transfer(int sourceid, int targetid, float money)
	// throws SQLException {
	//
	// Connection connection = null;
	// try {
	// connection = JdbcUtil.getConnection();
	// connection.setAutoCommit(false);
	//
	// QueryRunner queryRunner = new QueryRunner();
	// String sql1 = "update account set money=money-100 where id=1";
	// queryRunner.update(connection, sql1);
	//
	// String sql2 = "update account set money=money+100 where id=2";
	// queryRunner.update(connection, sql2);
	// connection.commit();
	// } catch (Exception e) {
	// if (connection != null) {
	// connection.rollback();
	// }
	// }finally{
	// connection.close();
	// }
	// }
	public void update(Account account) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set name=?,money=? where id=?";
		Object params[] = { account.getName(), account.getMoney(),
				account.getId() };
		queryRunner.update(JdbcUtil.getConnection(), sql, params);
	}

	public Account find(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from account where id=?";
		return queryRunner.query(JdbcUtil.getConnection(), sql,
				new BeanHandler<Account>(Account.class), id);
	}
}
