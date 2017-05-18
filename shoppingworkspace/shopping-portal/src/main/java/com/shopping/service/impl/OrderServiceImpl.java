package com.shopping.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.pojo.Order;
import com.shopping.pojo.ShoppingResult;
import com.shopping.service.OrderService;
import com.shopping.utils.HttpClientUtil;
import com.shopping.utils.JsonUtils;

@Service
public class OrderServiceImpl implements OrderService {
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;

	@Override
	public String createOrder(Order order) {

		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));

		ShoppingResult shoppingResult = ShoppingResult.format(json);
		if (shoppingResult.getStatus() == 200) {
			Object orderId = shoppingResult.getData();

			return orderId.toString();
		}

		return "";
	}
}