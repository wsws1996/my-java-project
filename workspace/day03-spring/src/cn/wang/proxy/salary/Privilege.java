package cn.wang.proxy.salary;

import org.aspectj.lang.ProceedingJoinPoint;

public class Privilege {
	private String access;

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
	public void controlShowSalary(ProceedingJoinPoint joinPoint) throws Throwable {
		if ("admin".equals(this.access)) {
			joinPoint.proceed();
		}else {
			System.out.println("您没有权限查看工资");
		}
	}
	
}
