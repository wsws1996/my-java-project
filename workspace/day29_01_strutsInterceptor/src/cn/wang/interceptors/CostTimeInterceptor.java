package cn.wang.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CostTimeInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5810543134898898042L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long time = System.nanoTime();
		String rtValue = invocation.invoke();
		long costTime = System.nanoTime() - time;
		System.out.println(invocation.getInvocationContext().getName() + ":"
				+ costTime);
		return rtValue;
	}

}
