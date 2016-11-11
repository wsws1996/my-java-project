package com.wang.common.web.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.danga.MemCached.MemCachedClient;

/**
 * 远程Session 存放在Memcached缓存服务器中的Session
 * 
 * @author wang
 *
 */
public class CacheSessionProvider implements SessionProvider {

	@Autowired
	private MemCachedClient memCachedClient;

	private int expiry = 30;// 分钟

	private static final String JSESSIONID = "JSESSIONID";

	@SuppressWarnings("unchecked")
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name,
			Serializable value) {
		Map<String, Serializable> session = (Map<String, Serializable>) memCachedClient
				.get(getSessionId(request, response));
		if (null == session) {
			session = new HashMap<String, Serializable>();
		}
		session.put(name, value);
		memCachedClient.set(getSessionId(request, response), session, expiry * 60);
	}

	@SuppressWarnings("unchecked")
	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name) {
		Map<String, Serializable> session = (Map<String, Serializable>) memCachedClient
				.get(getSessionId(request, response));
		if (null != session) {
			return session.get(name);
		}
		return null;
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		if (memCachedClient.keyExists(getSessionId(request, response))) {
			memCachedClient.delete(getSessionId(request, response));
		}
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (JSESSIONID.equals(cookie.getName())) {
					cookie.setMaxAge(0);
				}
			}
		}
	}

	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		// 所有的Cookie
		Cookie[] cookies = request.getCookies();

		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (JSESSIONID.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}

		// 生成一个
		String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
		Cookie cookie = new Cookie(JSESSIONID, sessionId);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		return sessionId;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

}
