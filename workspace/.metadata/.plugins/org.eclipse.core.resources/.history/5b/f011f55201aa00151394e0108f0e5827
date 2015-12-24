package cn.wang.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wang.utils.JdbcUtils_DBCP;

public class Demo1 {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils_DBCP.getConnection();
			connection.setAutoCommit(false);

			String sql1 = "update account set money =money-100 where name='aaa'";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();

			String sql2 = "update account set money =money+100 where name='bbb'";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(connection, preparedStatement, resultSet);
		}
	}
}
