package cn.wang.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyRequestAndSessionAttributeListener implements
		HttpSessionAttributeListener, ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println(arg0.getValue() + "r+");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println(arg0.getValue() + "r-");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println(arg0.getValue() + "r~");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println(arg0.getValue() + "s+");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println(arg0.getValue() + "s-");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println(arg0.getValue() + "s~");

	}

}
