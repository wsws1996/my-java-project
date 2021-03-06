package cn.wang.dao;

import cn.wang.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

	Customer findOne(String customerId);

	Customer find(String username, String password);

}
