package com.wang.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wang.core.bean.user.Buyer;

/**
 * 跳转登录页面 登录 个人资料 收货地址
 * 
 * @author wang
 *
 */
@Controller
public class ProfileController {
	// GET
	@RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.GET)
	public String login() {
		return "buyer/login";
	}

	// POST
	@RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.POST)
	public String login(Buyer buyer,String captcha,String returnUrl) {
		return "buyer/login";
	}
}
