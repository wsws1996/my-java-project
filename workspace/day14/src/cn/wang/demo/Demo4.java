package cn.wang.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import cn.wang.util.JdbcUtils;

public class Demo4 {
	@Test
	public void insert() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			statement = connection.createStatement();
			String sql = "insert into users(id,name,password,email,birthday)  values(4,'xxx','123','xx@sina.com','1980-09-09')";
			int num = statement.executeUpdate(sql);
			if (num > 0) {
				System.out.println("插入成功！！！");
			}
		} catch (Exception e) {
		} finally {
			JdbcUtils.release(connection, statement, resultSet);
		}
	}

	@Test
	public void delete() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "delete from users where id=4";
			statement = connection.createStatement();
			int num = statement.executeUpdate(sql);
			if (num > 0) {
				System.out.println("删除成功！！！");
			}
		} catch (Exception e) {
		} finally {
			JdbcUtils.release(connection, statement, resultSet);
		}
	}

	@Test
	public void update() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "update users set name='wuwang',email='wuwang@sina.com' where name='wangwu'";
			statement = connection.createStatement();
			int num = statement.executeUpdate(sql);
			if (num > 0) {
				System.out.println("更新成功！！！");
			}

		} catch (Exception e) {
		} finally {
			JdbcUtils.release(connection, statement, resultSet);
		}
	}

	@Test
	public void find() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from users where id=1";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}

		} catch (Exception e) {
		} finally {
			JdbcUtils.release(connection, statement, resultSet);
		}
	}

}
