package com.wang.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.core.bean.order.Order;
import com.wang.core.query.order.OrderQuery;
import com.wang.core.service.order.OrderService;

/**
 * 订单列表 订单查看
 * 
 * @author wang
 *
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order/list.do")
	public String list(Integer isPaiy, Integer state, ModelMap model) {
		OrderQuery orderQuery = new OrderQuery();
		// 支付状态
		if (null != isPaiy) {
			orderQuery.setIsPaiy(isPaiy);
		}

		// 订单状态
		if (null != state) {
			orderQuery.setState(state);
		}

		List<Order> orders = orderService.getOrderList(orderQuery);

		model.addAttribute("orders", orders);

		return "order/list";
	}
}
