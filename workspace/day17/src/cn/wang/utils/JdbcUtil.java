package cn.wang.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static ComboPooledDataSource dataSource = null;
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = threadLocal.get();
		if (connection == null) {
			connection = getDataSource().getConnection();
			threadLocal.set(connection);
		}
		return connection;
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static void startTransaction() {
		try {
			Connection connection = threadLocal.get();
			if (connection == null) {
				connection = getConnection();
				threadLocal.set(connection);
			}
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void rollback() {
		try {
			Connection connection = threadLocal.get();
			if (connection != null) {
				connection.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void commit() {
		try {
			Connection connection = threadLocal.get();
			if (connection != null) {
				connection.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void release() {
		try {
			Connection connection = threadLocal.get();
			if (connection != null) {
				connection.close();
				threadLocal.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
