package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.Order;
import com.shopping.pojo.ShoppingResult;
import com.shopping.service.OrderService;
import com.shopping.utils.ExceptionUtil;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/create")
	@ResponseBody
	public ShoppingResult createOrder(@RequestBody Order order) {
		try {
			ShoppingResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ShoppingResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
