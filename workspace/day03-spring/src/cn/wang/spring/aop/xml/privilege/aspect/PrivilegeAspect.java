package cn.wang.spring.aop.xml.privilege.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.wang.spring.aop.xml.privilege.annotation.AnnotationParse;
import cn.wang.spring.aop.xml.privilege.bean.Privilege;

public class PrivilegeAspect {
	private List<Privilege> privileges=new ArrayList<Privilege>();
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}



	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}



	public void isAccessMethod(ProceedingJoinPoint joinPoint)
			throws Throwable {
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		String methodAccess = AnnotationParse.parse(targetClass, methodName);
		boolean flag=false;
		for (Privilege privilege : privileges) {
			if (methodAccess.equals(privilege.getName())) {
				flag=true;
				break;
			}
		}
		if (flag) {
			joinPoint.proceed();
		}else {
			System.out.println("error! access deined");
		}
	}
}
