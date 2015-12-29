package cn.wang.demo;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import cn.wang.utils.JdbcUtils_C3P0;

public class Demo5 {

	public static void main(String[] args) throws SQLException {
		Connection connection = JdbcUtils_C3P0.getConnection();
		String sql = "select * from user where name=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "ddd");
		ParameterMetaData parameterMetaData = preparedStatement
				.getParameterMetaData();
		System.out.println(parameterMetaData.getParameterCount());
		System.out.println(parameterMetaData.getParameterType(1));
	}

}
