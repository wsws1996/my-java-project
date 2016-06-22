package com.wang.test;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;

public class Main {

	private static int index = 1;

	public static void main(String[] args) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(500);
		poolConfig.setMaxIdle(1000 * 60);
		poolConfig.setTestOnBorrow(true);

		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		JedisShardInfo A = new JedisShardInfo("127.0.0.1", 6379);
		JedisShardInfo B = new JedisShardInfo("127.0.0.1", 6380);
		shards.add(A);
		shards.add(B);

		ShardedJedisPool pool = new ShardedJedisPool(poolConfig, shards, Hashing.MURMUR_HASH);
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < 100; i++) {
			String key = String.valueOf(index++);
			ShardedJedis jds = null;
			try {
				jds = pool.getResource();

				System.out.println(key + ":" + jds.getShard(key).getClient().getPort());
				if (jds.getShard(key).getClient().getPort() == 6379) {
					count1++;
				} else {
					count2++;
				}
				System.out.println(jds.set(key, "11111111111111111111111"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.returnBrokenResource(jds);
			}
		}
		System.out.println("6379:" + count1);
		System.out.println("6380:" + count2);
		pool.close();
	}

}
