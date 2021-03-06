package cn.wang.demo;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import cn.wang.utils.JdbcUtils;

public class Demo1 {

	/*
	 * create database day15; use day15; create table testclob { id int primary
	 * key auto_increment, resume text };
	 */

	public static void main(String[] args) {

	}

	@Test
	public void add() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into testclob(resume) values(?)";
			preparedStatement = connection.prepareStatement(sql);
			// Reader reader= new InputStreamReader(
			// Demo1.class.getClassLoader().getResourceAsStream(
			// "1.txt"));
			String path = Demo1.class.getClassLoader().getResource("1.txt")
					.getPath();
			File file = new File(path);
			preparedStatement.setCharacterStream(1, new FileReader(file),
					file.length());
			int num = preparedStatement.executeUpdate();
			if (num > 0) {
				System.out.println("插入成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, null);
		}
	}

	@Test
	public void read() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select resume from testclob where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Reader reader = resultSet.getCharacterStream("resume");
				char buffer[] = new char[1024];
				@SuppressWarnings("unused")
				int len;
				while ((len = reader.read(buffer)) > 0) {
					System.out.println(new String(buffer));
				}
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}
}
