package cn.wang.proxy;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyInterceptor implements MethodInterceptor {

	private Object target;
	private Transaction transaction;

	public MyInterceptor(Object target, Transaction transaction) {
		super();
		this.target = target;
		this.transaction = transaction;
	}
	
	public Object createProxy() {
		Enhancer enhancer=new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(target.getClass());
		return enhancer.create();
	}

	@Override
	public Object intercept(Object object, Method method, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		this.transaction.beginTransaction();
		method.invoke(target);
		this.transaction.commit();
		return null;
	}
}
