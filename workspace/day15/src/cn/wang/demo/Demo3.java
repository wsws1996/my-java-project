package cn.wang.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import cn.wang.utils.JdbcUtils;

public class Demo3 {

	/*
	 * 
	 * create table testbench ( id int primary key, name varchar(20) )
	 */
	@Test
	public void testbench1() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql1 = "insert into testbatch (id,name) values(1,'aaa')";
			String sql2 = "insert into testbatch (id,name) values(2,'bbb')";
			String sql3 = "delete from testbatch where id=1";

			statement = connection.createStatement();
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			statement.executeBatch();
			statement.clearBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, statement, null);
		}
	}
	@Test
	public void testbench2() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into testbatch (id,name) values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < 10000000; i++) {
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, "aa" + i);
				preparedStatement.addBatch();
				if (i%1000==0) {
					System.out.println("1000条发送完成");
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}
			}
			preparedStatement.executeBatch(); 
			preparedStatement.clearBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, null);
		}
	}

}
