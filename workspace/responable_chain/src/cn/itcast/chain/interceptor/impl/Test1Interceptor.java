package cn.itcast.chain.interceptor.impl;

import cn.itcast.chain.interceptor.Interceptor;
import cn.itcast.chain.invocation.ActionInvocation;

public class Test1Interceptor implements Interceptor{

	public String intercept(ActionInvocation invocation) {
		System.out.println("1-start");
		String result = invocation.invoke();
		System.out.println("1-end");
		return result;
	}

}
