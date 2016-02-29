package cn.wang.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public Demo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/day14";
		String username = "root";
		String password = "root";
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection(url, username,
				password);
		Statement statement = connection.createStatement();
		String sql = "select id,name,password,email,birthday from users";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println("id:" + resultSet.getObject("id"));
			System.out.println("name:" + resultSet.getObject("name"));
			System.out.println("password:" + resultSet.getObject("password"));
			System.out.println("email:" + resultSet.getObject("email"));
			System.out.println("birthday:" + resultSet.getObject("birthday"));
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
}
