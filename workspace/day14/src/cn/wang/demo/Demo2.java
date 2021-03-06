package cn.wang.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

	public Demo2() {
	}

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/day14?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			String sql = "select id,name,password,email,birthday from users";
			resultSet = statement.executeQuery(sql);
			resultSet.afterLast();
			resultSet.previous();
			System.out.println("id:" + resultSet.getObject("id"));
			System.out.println("name:" + resultSet.getObject("name"));
			System.out.println("password:" + resultSet.getObject("password"));
			System.out.println("email:" + resultSet.getObject("email"));
			System.out.println("birthday:" + resultSet.getObject("birthday"));
		}  finally {
			/*
			 * if (resultSet != null) { try { resultSet.close(); } catch
			 * (Exception e2) { // TODO: handle exception } } if (statement !=
			 * null) { try { statement.close(); } catch (Exception e2) { //
			 * TODO: handle exception } } if (connection != null) { try {
			 * connection.close(); } catch (Exception e2) { // TODO: handle
			 * exception } }
			 */
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					if (statement != null) {
						try {
							statement.close();
						} catch (Exception e2) {
							// TODO: handle exception
						} finally {
							if (connection != null) {
								try {
									connection.close();
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
						}
					}
				}
			}
		}
	}
}
