package cn.wang.spring.aop.xml.exception.aspect;

import org.aspectj.lang.JoinPoint;

public class ExceptionAspect {
	public void throwingException(JoinPoint joinPoint, Throwable ex) {
		System.out.println("exception messagee:" + ex.getMessage());
	}
}
