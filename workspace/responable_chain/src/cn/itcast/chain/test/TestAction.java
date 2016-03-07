package cn.itcast.chain.test;

import org.junit.Test;

import cn.itcast.chain.invocation.impl.DefaultActionInvocation;

public class TestAction {
	@Test
	public void testAction(){
		DefaultActionInvocation invocation = new DefaultActionInvocation();
		System.out.println(invocation.invoke());
	}
}
