package cn.wang.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyBean2 implements HttpSessionActivationListener,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8404745890476897803L;

	/**
	 * 
	 */

	@Override
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println(httpSessionEvent.getSession() + "从硬盘回到内存了");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
		System.out.println(httpSessionEvent.getSession() + "被序列化到硬盘了");
	}

}
