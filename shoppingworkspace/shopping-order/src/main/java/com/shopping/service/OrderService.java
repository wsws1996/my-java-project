package com.shopping.service;

import java.util.List;

import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbOrder;
import com.shopping.pojo.TbOrderItem;
import com.shopping.pojo.TbOrderShipping;

public interface OrderService {
	public ShoppingResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
