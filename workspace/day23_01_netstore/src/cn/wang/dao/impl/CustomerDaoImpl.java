package cn.wang.dao.impl;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.wang.dao.CustomerDao;
import cn.wang.domain.Customer;
import cn.wang.util.DBCPUtil;

public class CustomerDaoImpl implements CustomerDao {
	private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void save(Customer customer) {
		try {
			queryRunner
					.update("insert into customers (id,username,password,nickname,phonenum,address,email) values(?,?,?,?,?,?,?)",
							customer.getId(), customer.getUsername(),
							customer.getPassword(), customer.getNickname(),
							customer.getPhonenum(), customer.getAddress(),
							customer.getEmail());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Customer findOne(String customerId) {
		try {
			return queryRunner.query("select * from customers where id=?",
					new BeanHandler<Customer>(Customer.class), customerId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Customer find(String username, String password) {
		try {
			return queryRunner.query("select * from customers where username=? and password=?",
					new BeanHandler<Customer>(Customer.class), username,password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
