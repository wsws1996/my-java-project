package cn.wang.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public static void update(String sql, Object params[]) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
			preparedStatement.executeUpdate();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	public static Object query(String sql, Object params[],
			ResultSetHandler resultSetHandler) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				preparedStatement.setObject(i + 1, params[i]);
			}
			resultSet = preparedStatement.executeQuery();
			Object object = resultSetHandler.handler(resultSet);
			preparedStatement.close();
			return object;
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}
}





