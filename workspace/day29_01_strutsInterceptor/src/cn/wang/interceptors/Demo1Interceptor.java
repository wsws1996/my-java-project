package cn.wang.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo1Interceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5436333310796469959L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截前");
		String rtValue = invocation.invoke();
		System.out.println("拦截后");
		return rtValue;
	}

}
