package cn.wang.proxy;

import net.sf.cglib.proxy.MethodInterceptor;

public class Transaction implements Interceptor{

	@Override
	public void interceptor() {
		System.out.println("transaction");
	}
	public void beginTransaction() {
		System.out.println("begin transaction");
	}
	public void commit() {
		System.out.println("commit");
	}
	
}
