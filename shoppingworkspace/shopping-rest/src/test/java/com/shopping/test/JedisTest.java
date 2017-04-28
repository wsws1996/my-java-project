package com.shopping.test;

import java.util.HashSet;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	@Test
	public void testJedisSingle() {
		Jedis jedis = new Jedis("192.168.33.10", 6379);
		jedis.set("name", "bar");
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();
	}

	@Test
	public void pool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(2);

		JedisPool pool = new JedisPool(config, "192.168.33.10", 6379);
		Jedis jedis = null;

		try {
			jedis = pool.getResource();
			jedis.set("name", "lisi");
			String name = jedis.get("name");
			System.out.println(name);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		pool.close();
	}

	@Test
	public void testJedisCluster() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(2);

		HashSet<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7001));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7002));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7003));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7004));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7005));
		jedisClusterNode.add(new HostAndPort("192.168.33.10", 7006));

		JedisCluster jedisCluster = new JedisCluster(jedisClusterNode);
		jedisCluster.set("name", "zhangsan");
		String value = jedisCluster.get("name");
		System.out.println(value);
		jedisCluster.close();

	}

}
