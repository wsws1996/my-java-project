package cn.wang.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.wang.domain.User;

public class UserLoginListener implements HttpSessionAttributeListener {

	@SuppressWarnings("unchecked")
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {

		ServletContext context = se.getSession().getServletContext();

		Map<String, HttpSession> map = (Map<String, HttpSession>) context
				.getAttribute("map");
		if (map == null) {
			map = new HashMap<String, HttpSession>();
			context.setAttribute("map", map);
		}

		Object object = se.getValue();
		HttpSession session = se.getSession();
		if (object instanceof User) {
			User user=(User)object;
			map.put(user.getUsername(), session);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

}
