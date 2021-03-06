package cn.wang.service.impl;

import java.util.List;

import cn.wang.dao.impl.CustomerDaoImpl;
import cn.wang.domain.Customer;
import cn.wang.domain.Page;

public class BussinessService {
	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

	public void addCustomer(Customer customer) {
		customerDaoImpl.add(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerDaoImpl.getAll();
	}

	public Page getPageData(String pagenum,String url) {
		int totalrecord = customerDaoImpl.getTotalrecord();
		if (pagenum == null) {
			Page page = new Page(totalrecord, 1);
			List<Customer> list = customerDaoImpl.getPageData(
					page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		} else {
			Page page = new Page(totalrecord, Integer.parseInt(pagenum));
			List<Customer> list = customerDaoImpl.getPageData(
					page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

	public Customer findCustomer(String id) {
		Customer customer= customerDaoImpl.find(id);
		return customer;
	}

	public void updateCustomer(Customer customer) {
		customerDaoImpl.update(customer);
	}

	public void deleteCustomer(String id) {
		customerDaoImpl.delete(id);
	}
}
