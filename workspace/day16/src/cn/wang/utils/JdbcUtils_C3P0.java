package cn.wang.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils_C3P0 {

	private static ComboPooledDataSource dataSource = null;
	static {
		try {
			/*
			 * dataSource=new ComboPooledDataSource();
			 * dataSource.setDriverClass("com.mysql.jdbc.Driver");
			 * dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day16");
			 * dataSource.setUser("root"); dataSource.setPassword("root");
			 * dataSource.setInitialPoolSize(10); dataSource.setMaxPoolSize(20);
			 * dataSource.setMinPoolSize(5);
			 */
			dataSource = new ComboPooledDataSource("wang");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void release(Connection connection, Statement statement,
			ResultSet resultSet) {
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