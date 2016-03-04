package cn.wang.spring.xml.transaction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Transaction {
	public void beginTransaction(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("methodname:" + methodName);
		System.out.println("class:" + joinpoint.getTarget().getClass());
		System.out.println("begin Transaction");
	}

	public void commit(JoinPoint joinpoint, Object val) {
		System.out.println("returning:" + val);
		System.out.println("commit");
	}

	public void finallyMethod() {
		System.out.println("finally method execute");
	}

	public void throwingMethod(JoinPoint joinPoint, Throwable throwable) {
		System.out.println("message:" + throwable.getMessage());
	}
	public void aroundMethod(ProceedingJoinPoint point) throws Throwable {
		System.out.println("pro");
		point.proceed();
	}
}
