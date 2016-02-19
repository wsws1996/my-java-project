package cn.wang.action;

import cn.wang.domain.Customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3274895416525218238L;
	private Customer customer = new Customer();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String register() {
		System.out.println(customer);
		if ("张三".equals(customer.getUsername())
				&& "123456".equals(customer.getPassword())) {
			return SUCCESS;
		}
		return LOGIN;
	}

	@Override
	public Customer getModel() {
		return customer;
	}
}
