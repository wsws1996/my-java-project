package cn.wang.dao.impl;

import java.util.List;

import cn.wang.dao.CustomerDao;
import cn.wang.domain.Customer;

public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {



	public CustomerDaoImpl() {
		super(Customer.class);
	}

	@Override
	public List<Customer> findPageCustomer(int startIndex, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
