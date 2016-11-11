package com.wang.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wang.common.web.session.SessionProvider;
import com.wang.core.bean.user.Buyer;

/**
 * 处理上下文 处理Session 全局
 * 
 * @author wang
 *
 */
public class SpringmvcInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionProvider sessionProvider;
	// 常量
	private static final String INERCEPTOR_URL = "/buyer/";

	private Integer adminId;

	// 方法前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (adminId != null) {
			Buyer buyer = new Buyer();
			buyer.setUsername("fbb2014");
			sessionProvider.setAttribute(request, response, Constants.BUYER_SESSION, buyer);
		} else {
			Buyer buyer = (Buyer) sessionProvider.getAttribute(request, response, Constants.BUYER_SESSION);
			boolean flag = false;
			if (null != buyer) {
				flag = true;
			}
			request.setAttribute("isLogin", flag);

			// 是否拦截
			String requestURI = request.getRequestURI();
			if (requestURI.startsWith(INERCEPTOR_URL)) {
				// 必须登录
				if (null == buyer) {
					response.sendRedirect("/shopping/login.shtml?returnUrl=" + request.getParameter("returnUrl"));
					return false;
				}
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}
