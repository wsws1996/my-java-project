package cn.wang.dao.impl;

import java.util.List;

import cn.wang.domain.Customer;
import cn.wang.exception.DaoException;
import cn.wang.utils.BeanHandler;
import cn.wang.utils.BeanListHandler;
import cn.wang.utils.IntegerHandler;
import cn.wang.utils.JdbcUtils;

public class CustomerDaoImpl {

	public void add(Customer customer) {
		try {
			String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			Object params[] = { customer.getId(), customer.getName(),
					customer.getGender(), customer.getBirthday(),
					customer.getCellphone(), customer.getEmail(),
					customer.getPreference(), customer.getType(),
					customer.getDescription() };
			JdbcUtils.update(sql, params);
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	public void update(Customer customer) {
		try {
			String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
			Object params[] = { customer.getName(), customer.getGender(),
					customer.getBirthday(), customer.getCellphone(),
					customer.getEmail(), customer.getPreference(),
					customer.getType(), customer.getDescription(),
					customer.getId() };
			JdbcUtils.update(sql, params);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void delete(String id) {
		try {
			String sql = "delete from customer where id=?";
			Object params[] = { id };
			JdbcUtils.update(sql, params);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Customer find(String id) {
		try {
			String sql = "select * from customer where id=?";
			Object params[] = { id };
			return (Customer) JdbcUtils.query(sql, params, new BeanHandler(
					Customer.class));
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getPageData(int startindex, int pagesize) {
		try {
			String sql = "select * from customer limit ?,?";
			Object params[] = { startindex, pagesize };
			return (List<Customer>) JdbcUtils.query(sql, params,
					new BeanListHandler(Customer.class));

		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public int getTotalrecord() {
		try {
			String sql = "select count(*) from customer";
			Object params[] = {};
			long l = (Long) JdbcUtils.query(sql, params, new IntegerHandler());
			return (int) l;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
