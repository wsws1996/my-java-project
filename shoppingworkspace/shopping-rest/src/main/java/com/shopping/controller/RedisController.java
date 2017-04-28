package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.pojo.ShoppingResult;
import com.shopping.service.RedisService;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {
	@Autowired
	private RedisService redisService;

	@RequestMapping("/content/{contentId}")
	@ResponseBody
	public ShoppingResult contentCacheSync(@PathVariable Long contentId) {
		ShoppingResult result = redisService.syncContent(contentId);
		return result;
	}
}
