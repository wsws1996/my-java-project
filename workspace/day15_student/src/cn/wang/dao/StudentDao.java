package cn.wang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.wang.domain.Student;
import cn.wang.utils.JdbcUtils;

public class StudentDao {
	public List getPageData(int startindex, int pagesize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from student limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startindex);
			preparedStatement.setInt(2, pagesize);
			resultSet = preparedStatement.executeQuery();
			List list = new ArrayList();
			while (resultSet.next()) {
				Student student = new Student();
				student.setName(resultSet.getString("name"));
				student.setId(resultSet.getInt("id"));
				list.add(student);
			}
			return list;
		} catch (Exception e) {
			new RuntimeException(e.getMessage());
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
		return null;
	}
	public int getTotalrecord() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql="select count(*) from student";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
			return 0;
		} catch (Exception e) {
			new RuntimeException(e.getMessage());
		} finally {
			JdbcUtils.release(connection, preparedStatement, resultSet);
		}
		return 0;
	}
	/* 
	 * Connection connection = null;
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
	 */
}
