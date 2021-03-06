package cn.wang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from customer";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			List<Customer> list = new ArrayList<Customer>();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setBirthday(resultSet.getDate("birthday"));
				customer.setCellphone(resultSet.getString("cellphone"));
				customer.setDescription(resultSet.getString("description"));
				customer.setEmail(resultSet.getString("email"));
				customer.setGender(resultSet.getString("gender"));
				customer.setId(resultSet.getString("id"));
				customer.setName(resultSet.getString("name"));
				customer.setPreference(resultSet.getString("preference"));
				customer.setType(resultSet.getString("type"));
				list.add(customer);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}
}
