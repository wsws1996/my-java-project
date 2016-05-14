package com.wang.purchasing.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wang.purchasing.util.UserUtil;
import com.wang.purchasing.vo.ActiveUser;

public class LoginInterceptor implements HandlerInterceptor {

	// 执行时机：进入action方法之前去执行
	// 应用场景：用户身份校验拦截，用户权限拦截

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// 校验是否是公开地址

		// 获取用户请求url
		String url = request.getRequestURI();

		//判断请求的url是否登录地址，如果是则放行
		if(url.indexOf("login.action")>=0 || url.indexOf("loginSubmit.action")>=0){
			return true;
		}

		// 校验用户是否登录
		
		HttpSession session = request.getSession();
		ActiveUser activeUser = UserUtil.getUserFromSession(session);
		if (activeUser != null) {
			// 用户已登录放行
			return true;
		}
		
		// 跳转到登录页面
		 request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
		 response);


		return false;
	}

	// 执行时机：执行完action方法返回modelAndView之前去执行
	// 场景：将页面上所需要公用数据在这里统一设置，比如页面需要一个功能导航
	// 在这里统一修改view
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	// 执行时机：action执行完成且modelAndView完成了
	// 场景：统一记录系统操作日志
	// 监控action执行的时间，在preHandle中记录起始时间，在afterCompletion记录结束时间，统计出action执行总时长
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
