package cn.wang.dao;

import java.sql.SQLException;

import cn.wang.domain.Account;

public interface AccountDao {

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
	public abstract void update(Account account) throws SQLException;

	public abstract Account find(int id) throws SQLException;

}