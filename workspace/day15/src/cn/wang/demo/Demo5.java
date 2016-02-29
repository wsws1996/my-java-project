package cn.wang.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import cn.wang.utils.JdbcUtils;

public class Demo5 {
	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement callableStatement=null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			callableStatement= connection.prepareCall("{call demoSp(?,?)}");
			callableStatement.setString(1, "xxxx");
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.execute();
			String result= callableStatement.getString(2);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, null, resultSet);
		}
	}
}
