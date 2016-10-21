package com.wang.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * Session 供应类
 * 
 * @author wang
 *
 */
public interface SessionProvider {

	// 往Session设置值
	public void setAttribute(HttpServletRequest request, String name, Serializable value);

	// 从Session中取值
	public Serializable getAttribute(HttpServletRequest request, String name);

	// 退出登录
	public void logout(HttpServletRequest request);

	// 获取SessionID
	public String getSessionId(HttpServletRequest request);
}
