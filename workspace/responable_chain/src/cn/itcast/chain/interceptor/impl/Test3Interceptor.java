package cn.itcast.chain.interceptor.impl;

import cn.itcast.chain.interceptor.Interceptor;
import cn.itcast.chain.invocation.ActionInvocation;

public class Test3Interceptor implements Interceptor{

	public String intercept(ActionInvocation invocation) {
		System.out.println("3-start");
		String result = invocation.invoke();
		System.out.println("3-end");
		return result;
	}

}
