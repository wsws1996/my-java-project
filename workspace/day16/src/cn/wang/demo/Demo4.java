package cn.wang.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import cn.wang.utils.JdbcUtils_C3P0;

public class Demo4 {
	public static void main(String[] args) throws SQLException {
		Connection connection= JdbcUtils_C3P0.getConnection();
		DatabaseMetaData metaData= connection.getMetaData();
		System.out.println(metaData.getDriverVersion());
		
	}
}
