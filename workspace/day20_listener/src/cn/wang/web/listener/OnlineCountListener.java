package cn.wang.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {

	int num = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		Integer num = (Integer) context.getAttribute("num");
		if (num == null) {
			context.setAttribute("num", 1);
		} else {
			num++;
			context.setAttribute("num", num);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		Integer num = (Integer) context.getAttribute("num");
		if (num == null) {
			context.setAttribute("num", 1);
		} else {
			num--;
			context.setAttribute("num", num);
		}
	}

}
