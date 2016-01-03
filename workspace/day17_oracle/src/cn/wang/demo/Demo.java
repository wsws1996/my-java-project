package cn.wang.demo;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import oracle.sql.BLOB;
import cn.wang.utils.JdbcUtils;

public class Demo {

	public static void main(String[] args) {

	}

	@Test
	public void add() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);
			String sql = "insert into testblob(id,image) values(?,empty_blob())";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);

			preparedStatement.executeUpdate();

			sql = "select image from testblob where id=? for update";
			preparedStatement.close();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				BLOB blob = (BLOB) resultSet.getBlob("image");
				OutputStream outputStream = blob.getBinaryOutputStream();

				InputStream inputStream = Demo.class.getClassLoader()
						.getResourceAsStream("1.jpg");
				byte buffer[] = new byte[1024];
				int len = 0;
				while ((len = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, len);
				}
				inputStream.close();
				outputStream.close();
			}
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	
	@Test
	public void find() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select image from testblob where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				BLOB blob = (BLOB) resultSet.getBlob("image");
				InputStream inputStream = blob.getBinaryStream();
				FileOutputStream fileOutputStream = new FileOutputStream(
						"/home/wang/桌面/1.jpg");
				byte buffer[] = new byte[1024];
				int len = 0;
				while ((len = inputStream.read(buffer)) > 0) {
					fileOutputStream.write(buffer, 0, len);
				}
				inputStream.close();
				fileOutputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

}
