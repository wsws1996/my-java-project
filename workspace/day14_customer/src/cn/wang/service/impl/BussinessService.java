package cn.wang.service.impl;

import cn.wang.dao.impl.CustomerDaoImpl;
import cn.wang.domain.Customer;

public class BussinessService {
	CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	public void addCustomer(Customer customer) {
		customerDaoImpl.add(customer);
	}
}
