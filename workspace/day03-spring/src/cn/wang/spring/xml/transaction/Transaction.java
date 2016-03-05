package cn.wang.spring.xml.transaction;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("transaction")
@Aspect
public class Transaction {
	@Pointcut("execution(* cn.wang.spring.xml.transaction.PersonDaoImpl.*(..))")
	public void aa(){}
	
	@Before("aa()")
	public void beginTransaction() {
		System.out.println("begin Transaction");
	}
	
	@AfterReturning("aa()")
	public void commit() {
		System.out.println("commit");
	}
}
