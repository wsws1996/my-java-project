package cn.wang.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JdbcUtils {
	private static DataSource dataSource = null;
	private static Connection connection = null;
	static {
		try {
			InputStream inputStream = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			return connection;
		}
	}

	public static void release(Connection conn, Statement statement,
			ResultSet resultSet) {
		// 该方法参考以前的项目
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
