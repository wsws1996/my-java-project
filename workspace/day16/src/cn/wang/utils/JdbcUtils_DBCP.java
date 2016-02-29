package cn.wang.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import cn.wang.demo.JdbcPool;

public class JdbcUtils_DBCP {

	private static DataSource ds = null;
	static {
		try {
			InputStream inputStream = JdbcUtils_DBCP.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			ds = factory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
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
