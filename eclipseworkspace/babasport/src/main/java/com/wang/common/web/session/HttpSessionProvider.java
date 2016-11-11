package com.wang.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 本地Session
 * 
 * @author wang
 *
 */
public class HttpSessionProvider implements SessionProvider {

	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name,
			Serializable value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return request.getSession().getId();
	}

}
