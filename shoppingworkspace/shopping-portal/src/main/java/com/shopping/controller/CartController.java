package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.pojo.CartItem;
import com.shopping.pojo.ShoppingResult;
import com.shopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable Long itemId, @RequestParam(defaultValue = "1") Integer num,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		ShoppingResult result = cartService.addCartItem(itemId, num, request, response);
		if (result.getStatus() != 200) {
			model.addAttribute("message", result.getMsg());
			return "error/exception";
		}
		return "redirect:/cart/cart.html";
	}

	@RequestMapping("/cart")
	public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CartItem> list = cartService.getCartItemList(request, response);
		model.addAttribute("cartList", list);
		return "cart";
	}

	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		ShoppingResult result = cartService.deleteCartItem(itemId, request, response);
		if (result.getStatus() != 200) {
			model.addAttribute("message", result.getMsg());
			return "error/exception";
		}
		return "redirect:/cart/cart.html";
	}
}
