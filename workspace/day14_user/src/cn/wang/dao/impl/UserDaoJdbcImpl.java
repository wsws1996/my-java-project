package cn.wang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.wang.dao.UserDao;
import cn.wang.domain.User;
import cn.wang.exception.DaoException;
import cn.wang.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public User find(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			// String sql = "select * from users where username= '" + username
			// + "' and password='" + password + "'";
			String sql = "select * from users where username=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			// statement = connection.createStatement();
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setId("id");
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setBirthday(resultSet.getDate("birthday"));
				return user;
			}
			return null;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into users(id,username,password,email,birthday) values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setDate(5, new java.sql.Date(user.getBirthday()
					.getTime()));

			// String sql =
			// "insert into users(id,username,password,email,birthday) values('"
			// + user.getId()
			// + "','"
			// + user.getUsername()
			// + "','"
			// + user.getPassword()
			// + "','"
			// + user.getEmail()
			// + "','"
			// + user.getBirthday().toLocaleString() + "')";
			// statement = connection.createStatement();
			// statement.executeUpdate(sql);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	@Override
	public User find(String username) {
		Connection connection = null;
		// Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from users where username= ?";
			// String sql = "select * from users where username= '" + username
			// + "'";
			// statement = connection.createStatement();
			// resultSet = statement.executeQuery(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				User user = new User();
				user.setId("id");
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setBirthday(resultSet.getDate("birthday"));
				return user;
			}
			return null;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

}
