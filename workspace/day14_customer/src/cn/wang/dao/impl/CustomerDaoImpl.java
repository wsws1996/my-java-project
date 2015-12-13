package cn.wang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.wang.domain.Customer;
import cn.wang.exception.DaoException;
import cn.wang.utils.JdbcUtils;

public class CustomerDaoImpl {

	public void add(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getGender());
			preparedStatement.setDate(4, new java.sql.Date(customer
					.getBirthday().getTime()));
			preparedStatement.setString(5, customer.getCellphone());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setString(7, customer.getPreference());
			preparedStatement.setString(8, customer.getType());
			preparedStatement.setString(9, customer.getDescription());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	public void update(Customer customer) {
		
	}

	public void delete(String id) {

	}

	public Customer find(String id) {
		return null;
	}

	public List<Customer> getAll() {
		return null;
	}
}
