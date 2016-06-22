package com.wang.mybatis.mapper;

import java.util.List;

import com.wang.mybatis.po.Orders;
import com.wang.mybatis.po.OrdersCustom;

public interface OrdersMapperCustom {
	public List<OrdersCustom> findOrderUserList() throws Exception;

	public List<Orders> findOrderUserListResultMap() throws Exception;

	public List<Orders> findOrdersUserDetailList() throws Exception;

	public List<Orders> findOrdersUserDetailItemList() throws Exception;

	public List<Orders> findOrdersList() throws Exception;
}
