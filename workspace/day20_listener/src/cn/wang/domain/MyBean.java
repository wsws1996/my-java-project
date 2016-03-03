package cn.wang.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyBean implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent hsbe) {
		System.out.println("被加到session");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent hsbe) {
		System.out.println("被session踢出来");
	}

}
