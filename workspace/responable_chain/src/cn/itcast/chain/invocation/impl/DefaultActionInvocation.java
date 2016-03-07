package cn.itcast.chain.invocation.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.itcast.chain.action.TestAction;
import cn.itcast.chain.interceptor.Interceptor;
import cn.itcast.chain.interceptor.impl.Test1Interceptor;
import cn.itcast.chain.interceptor.impl.Test2Interceptor;
import cn.itcast.chain.interceptor.impl.Test3Interceptor;
import cn.itcast.chain.invocation.ActionInvocation;

public class DefaultActionInvocation implements ActionInvocation{
	/**
	 * 声明了所有的拦截器的迭代器的形式
	 */
	private Iterator<Interceptor> interceptors;
	private String resultCode = null;
	public DefaultActionInvocation(){
		/**
		 * 初始化拦截器
		 */
		init();
	}
	
	public void init(){
		/**
		 * 创建了一个拦截器的集合
		 */
		List<Interceptor> inter = new ArrayList<Interceptor>();
		/**
		 * 创建了三个具体的拦截器
		 */
		Test1Interceptor interceptor1 = new Test1Interceptor();
		inter.add(interceptor1);
		Test2Interceptor interceptor2 = new Test2Interceptor();
		inter.add(interceptor2);
		Test3Interceptor interceptor3 = new Test3Interceptor();
		inter.add(interceptor3);
		this.interceptors = inter.iterator();
	}

	public String invoke() {
		if(interceptors.hasNext()){//判断是否有下一个拦截器
			/**
			 * 如果有，先返回下一个拦截器
			 */
			Interceptor interceptor = interceptors.next();
			resultCode = interceptor.intercept(DefaultActionInvocation.this);
		}else{
			resultCode = executeAction();
		}
		return resultCode;
	}
	
	private String executeAction(){
		return new TestAction().execute();
	}
}
