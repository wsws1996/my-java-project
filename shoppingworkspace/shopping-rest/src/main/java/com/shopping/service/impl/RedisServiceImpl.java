package com.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.pojo.ShoppingResult;
import com.shopping.service.RedisService;
import com.shopping.utils.ExceptionUtil;

import redis.clients.jedis.JedisCluster;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisCluster jedisCluster;

	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;

	@Override
	public ShoppingResult syncContent(long contentId) {
		try {
			jedisCluster.hdel(INDEX_CONTENT_REDIS_KEY, contentId + "");
		} catch (Exception e) {
			e.printStackTrace();
			return ShoppingResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ShoppingResult.ok();
	}

}
