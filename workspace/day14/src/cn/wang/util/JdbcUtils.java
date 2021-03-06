package cn.wang.util;

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
	private static String driver = null;
	static {
		InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream(
				"db.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
			driver = properties.getProperty("driver");
			password = properties.getProperty("password");
			username = properties.getProperty("username");
			url = properties.getProperty("url");
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
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
