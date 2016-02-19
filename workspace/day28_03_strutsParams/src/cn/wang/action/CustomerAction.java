package cn.wang.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wang.domain.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	private List<Customer> customers = new ArrayList<Customer>();
	private Map<String, Customer> customers1 = new HashMap<String, Customer>();

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	

	public Map<String, Customer> getCustomers1() {
		return customers1;
	}

	public void setCustomers1(Map<String, Customer> customers1) {
		this.customers1 = customers1;
	}

	public String register() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		return null;
	}

	public String register1() {
		for (Map.Entry<String, Customer> me : customers1.entrySet()) {
			System.out.println(me.getKey()+":"+me.getValue());
		}
		return null;
	}
}
