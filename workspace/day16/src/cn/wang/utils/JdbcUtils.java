package cn.wang.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.wang.demo.JdbcPool;

public class JdbcUtils {

	private static JdbcPool pool = new JdbcPool();

	public static Connection getConnection() throws SQLException {
		return pool.getConnection();
	}

	public static void release(Connection connection, Statement statement,
			ResultSet resultSet) {
		/*
		 * if (resultSet != null) { try { resultSet.close(); } catch (Exception
		 * e) { } finally { if (statement != null) { try { statement.close(); }
		 * catch (Exception e) { } finally { if (connection != null) { try {
		 * connection.close(); } catch (Exception e) { } } } } } }
		 */
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultSet = null;

		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}