package com.wang.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class JdbcTest {
	private static String sql="SELECT * from `user` where username = ?";
	
	public static void main(String[] args) throws Exception {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "fab13b21-152b-11e6-b572-38b1db435f53");
			
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id=resultSet.getInt("id");
				String username=resultSet.getString("username");
				Date birthday =resultSet.getDate("birthday");
				System.out.println(id+":"+username+":"+birthday);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (resultSet!=null) {
				resultSet.close();
			}
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		}
	}
}
