package org.wang.elec.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemUtils implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String path = request.getServletPath();
		this.initIndexPage(request, path);
		chain.doFilter(request, response);
	}

	private void initIndexPage(HttpServletRequest request, String path) {
		if (path != null && path.equals("/index.jsp")) {
			// 从Cookie中获取记住我中存放的用户名和密码
			String name = "";
			String password = "";
			String checked = "";
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if ("name".equals(cookie.getName())) {
						name = cookie.getValue();
						try {
							//中文支持
							name = URLDecoder.decode(name, "UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						checked = "checked";
					}
					if ("password".equals(cookie.getName())) {
						password = cookie.getValue();
					}
				}
			}
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.setAttribute("checked", checked);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
