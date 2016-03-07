package cn.itcast.chain.interceptor.impl;

import cn.itcast.chain.interceptor.Interceptor;
import cn.itcast.chain.invocation.ActionInvocation;

public class Test2Interceptor implements Interceptor{

	public String intercept(ActionInvocation invocation) {
		System.out.println("2-start");
		return invocation.invoke();
//		System.out.println("2-end");
//		return result;
	}

}
