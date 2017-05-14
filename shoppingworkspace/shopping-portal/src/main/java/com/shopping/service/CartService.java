package com.shopping.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.pojo.CartItem;
import com.shopping.pojo.ShoppingResult;

public interface CartService {
	public ShoppingResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);

	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

	public ShoppingResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
