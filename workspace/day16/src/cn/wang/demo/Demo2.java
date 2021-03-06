package cn.wang.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.wang.utils.JdbcUtils;

public class Demo2 {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Savepoint savepoint=null;
		try {
			connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);

			String sql1 = "update account set money =money-100 where name='aaa'";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();
			savepoint = connection.setSavepoint();
			
			String sql2 = "update account set money =money+100 where name='bbb'";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
			int x=1/0;
			
			String sql3 = "update account set money =money+100 where name='ccc'";
			preparedStatement = connection.prepareStatement(sql3);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback(savepoint);
				connection.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}
}
