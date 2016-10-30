package com.wang.core.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.common.web.session.SessionProvider;
import com.wang.core.bean.BuyCart;
import com.wang.core.bean.BuyItem;
import com.wang.core.bean.order.Order;
import com.wang.core.bean.product.Sku;
import com.wang.core.bean.user.Buyer;
import com.wang.core.service.order.OrderService;
import com.wang.core.service.product.SkuService;
import com.wang.core.web.Constants;

/**
 * 提交订单 前台
 * 
 * @author wang
 *
 */
@Controller
public class FrontOrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/buyer/confirmOrder.shtml")
	public String confirmOrder(Order order, HttpServletRequest request, HttpServletResponse response) {
		// 1.接收前台传四个参数
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);
		// 声明
		BuyCart buyCart = null;
		// 判断Cookie是否有购物车
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (Constants.BUYCART_COOKIE.equals(cookie.getName())) {
					// 如果有了 就使用此购物车
					String value = cookie.getValue();
					try {
						buyCart = om.readValue(value, BuyCart.class);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

		// 填充购物车信息
		List<BuyItem> items = buyCart.getItems();
		for (BuyItem item : items) {
			Sku s = skuService.getSkuByKey(item.getSku().getId());
			item.setSku(s);
		}

		Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constants.BUYER_SESSION);

		// 用户id
		order.setBuyerId(buyer.getUsername());

		// 保存订单 订单详情两张表
		orderService.addOrder(order, buyCart);
		// 清空购物车
		Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "product/confirmOrder";
	}

	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private SkuService skuService;
}
