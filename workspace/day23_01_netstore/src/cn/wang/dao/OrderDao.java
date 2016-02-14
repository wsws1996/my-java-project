package cn.wang.dao;

import java.util.List;

import cn.wang.domain.Order;

public interface OrderDao {
	/**
	 * 保存订单的基本信息
	 * 还要保存订单关联的订单项信息
	 * @param order
	 */
	void save(Order order);

	/**
	 * 根据订单号查询订单
	 * @param ordernum
	 * @return 订单的基本信息
	 */
	Order findByNum(String ordernum);
	
	/**
	 * 根据客户的id查询他的订单，按照日期降序排列
	 * @param id
	 * @return
	 */
	List<Order> findByCustomer(String customerid);
	
	void updateStatus(Order order);

}
