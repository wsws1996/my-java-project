package cn.wang.service.impl;

import java.util.List;

import cn.wang.dao.impl.CustomerDaoImpl;
import cn.wang.domain.Customer;

public class BussinessService {
	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

	public void addCustomer(Customer customer) {
		customerDaoImpl.add(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerDaoImpl.getAll();
	}
}
