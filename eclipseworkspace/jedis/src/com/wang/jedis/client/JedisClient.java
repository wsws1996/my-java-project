package com.wang.jedis.client;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClient {
	@Test
	public void jedisClient() {
		// jedis
		Jedis jedis = new Jedis("10.42.0.154", 6379);
		// 通过redis赋值
		jedis.set("s2", "222");
		// 通过redis取值
		String result = jedis.get("s2");
		System.out.println(result);
		// 关闭jedis
		jedis.close();
	}

	@Test
	public void jedisPool() {
		// jedisPool
		JedisPool pool = new JedisPool("10.42.0.154", 6379);
		// 通过连接池获取jedis对象
		Jedis jedis = pool.getResource();

		jedis.set("s4", "444");
		String result = jedis.get("s3");
		System.out.println(result);
		jedis.close();
		pool.close();
	}
}
