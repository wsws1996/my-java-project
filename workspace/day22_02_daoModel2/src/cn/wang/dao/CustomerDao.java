package cn.wang.dao;

import java.util.List;

import cn.wang.domain.Customer;

public interface CustomerDao extends Dao<Customer> {

	List<Customer> findPageCustomer(int startIndex, int size);
}
