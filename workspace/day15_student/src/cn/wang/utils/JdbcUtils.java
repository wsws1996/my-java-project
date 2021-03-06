package cn.wang.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		try {
			InputStream inputStream = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			String driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}

	public static void release(Connection connection, Statement statement,
			ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (Exception e) {
					} finally {
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception e) {
							}
						}
					}
				}
			}
		}
	}
}
