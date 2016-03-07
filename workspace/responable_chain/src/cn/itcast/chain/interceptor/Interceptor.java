package cn.itcast.chain.interceptor;

import cn.itcast.chain.invocation.ActionInvocation;
/**
 * 拦截器的总的接口
 * @author zd
 *
 */
public interface Interceptor {
	String intercept(ActionInvocation invocation);
}
