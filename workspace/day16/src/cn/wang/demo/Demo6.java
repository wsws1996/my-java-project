package cn.wang.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cn.wang.utils.JdbcUtils_C3P0;

public class Demo6 {

	public static void main(String[] args) throws SQLException {
		Connection connection = JdbcUtils_C3P0.getConnection();
		String sql = "select * from account";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		System.out.println(resultSetMetaData.getColumnCount());
		System.out.println(resultSetMetaData.getColumnName(1));
	}

}
