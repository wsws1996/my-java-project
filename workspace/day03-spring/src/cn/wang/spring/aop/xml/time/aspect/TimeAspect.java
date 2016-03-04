package cn.wang.spring.aop.xml.time.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeAspect {
	public void methodExecuationTime(ProceedingJoinPoint joinPoint)
			throws Throwable {
		String targetClassName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		long preTime = System.nanoTime();
		joinPoint.proceed();
		long postTime = System.nanoTime();
		long executionTime = postTime - preTime;
		System.out.println("current class:" + targetClassName);
		System.out.println("current method:" + methodName);
		System.out.println("begin time:" + preTime);
		System.out.println("end time:" + postTime);
		System.out.println("execution time:" + executionTime);
	}
}
