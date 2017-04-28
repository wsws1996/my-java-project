package com.shopping.service;

import com.shopping.pojo.ShoppingResult;

public interface RedisService {
	public ShoppingResult syncContent(long contentId);
}
