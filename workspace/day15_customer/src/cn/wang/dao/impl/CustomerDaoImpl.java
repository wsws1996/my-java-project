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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setDate(3, new java.sql.Date(customer
					.getBirthday().getTime()));
			preparedStatement.setString(4, customer.getCellphone());
			preparedStatement.setString(5, customer.getEmail());
			preparedStatement.setString(6, customer.getPreference());
			preparedStatement.setString(7, customer.getType());
			preparedStatement.setString(8, customer.getDescription());
			preparedStatement.setString(9, customer.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	public void delete(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "delete from customer where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	public Customer find(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from customer where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
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
				return customer;
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
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

	public List<Customer> getPageData(int startindex, int pagesize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from customer limit ?,?";
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, startindex);
			preparedStatement.setInt(2, pagesize);
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
			return list;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}

	public int getTotalrecord() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select count(*) from customer";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
			return 0;
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
	}
}
