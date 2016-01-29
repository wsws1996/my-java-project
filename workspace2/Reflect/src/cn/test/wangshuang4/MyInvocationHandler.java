package cn.test.wangshuang4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	public MyInvocationHandler(Object target) {
		// TODO Auto-generated constructor stub
		this.target=target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("权限校验");
		Object result= method.invoke(target, args);
		System.out.println("日志记录");
		return result;
	}

}
