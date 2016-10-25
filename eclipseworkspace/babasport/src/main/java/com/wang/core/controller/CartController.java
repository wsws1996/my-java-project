package com.wang.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 购物车
 * 
 * @author wang
 *
 */
@Controller
public class CartController {
	@RequestMapping(value = "/shopping/buyCart.shtml")
	public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId) {
		return "product/cart";
	}
}
