package cn.wang.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import cn.wang.utils.JdbcUtils;

public class Demo2 {

	/*
	 * 
	 * create table testblob ( id int primary key auto_increment, image blob );
	 */
	@Test
	public void add() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into testblob(image) values(?)";
			preparedStatement = connection.prepareStatement(sql);
			String path = Demo2.class.getClassLoader().getResource("01.jpg")
					.getPath();
			preparedStatement.setBinaryStream(1, new FileInputStream(path),
					(new File(path)).length());
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
			String sql = "select image from testblob where id=?";
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				InputStream inputStream = resultSet.getBinaryStream("image");
				int len=0;
				byte buffer[]=new byte[1024];
				FileOutputStream fileOutputStream=new FileOutputStream("/home/wang/桌面/1.jpg");
				while ((len=inputStream.read(buffer))>0) {
					fileOutputStream.write(buffer,0,len);
				}
				fileOutputStream.close();
				inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}
}
