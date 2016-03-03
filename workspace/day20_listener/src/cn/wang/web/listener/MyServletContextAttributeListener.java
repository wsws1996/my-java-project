package cn.wang.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println(scae.getValue() + "被添加");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println(scae.getValue() + "被移除");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println(scae.getValue() + "被替换");
	}

}
