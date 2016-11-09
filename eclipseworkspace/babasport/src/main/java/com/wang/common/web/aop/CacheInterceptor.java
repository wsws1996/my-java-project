package com.wang.common.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 缓存Memcached中数据的切面对象 around after
 * 
 * @author wang
 *
 */
public class CacheInterceptor {
	// 配置环绕方法
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		//去Memcached中看看有没有需要的数据 包名+类名+方法名+参数（多个）
		return pjp.proceed();
	}
}
