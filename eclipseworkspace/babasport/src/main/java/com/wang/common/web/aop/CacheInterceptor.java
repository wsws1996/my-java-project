package com.wang.common.web.aop;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.annotation.Autowired;

import com.danga.MemCached.MemCachedClient;

import cn.itcast.common.web.aop.MemCachedUtil;

/**
 * 缓存Memcached中数据的切面对象 around after
 * 
 * @author wang
 *
 */
public class CacheInterceptor {

	@Autowired
	private MemCachedClient memcachedClient;

	private static final int TIMEOUT = 360000;// 秒

	private int expiry = TIMEOUT;

	// 配置环绕方法
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		// 去Memcached中看看有没有需要的数据 包名+类名+方法名+参数（多个）
		String cacheKey = getCacheKey(pjp);
		System.out.println(cacheKey);
		// 判断Memcached服务器状态
		if (memcachedClient.stats().isEmpty()) {
			System.out.println("Memcached服务器连接失败");
			return pjp.proceed();
		}
		// 返回值
		if (null == memcachedClient.get(cacheKey)) {
			// 回Service
			Object proceed = pjp.proceed();
			// 先到Memcached设置一次
			memcachedClient.set(cacheKey, proceed, expiry);
		}

		return memcachedClient.get(cacheKey);
	}

	// 后置由于数据库数据变更，清理get*
	public void doAfter(JoinPoint jp) {
		String packageName = jp.getTarget().getClass().getName();
		// 包名 + 类名开始的都清理
		Map<String, Object> keySet = MemCachedUtil.getKeySet(memcachedClient);
		Set<Entry<String, Object>> entrySet = keySet.entrySet();
		// 遍历
		for (Entry<String, Object> entry : entrySet) {
			if (entry.getKey().startsWith(packageName)) {
				memcachedClient.delete(entry.getKey());
			}
		}
	}

	// 包名+类名+方法名+参数（多个）生成Key
	public String getCacheKey(ProceedingJoinPoint pjp) {
		// StringBuilder
		StringBuilder key = new StringBuilder();
		// 包名+类名
		String packageName = pjp.getTarget().getClass().getName();
		key.append(packageName);
		// 方法名
		String methodName = pjp.getSignature().getName();
		key.append(".").append(methodName);
		Object[] args = pjp.getArgs();

		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Inclusion.NON_NULL);

		for (Object arg : args) {
			// 流
			StringWriter str = new StringWriter();
			// 对象转JSON 写
			try {
				om.writeValue(str, arg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 参数
			key.append(".").append(str);
		}
		return key.toString();
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

}
