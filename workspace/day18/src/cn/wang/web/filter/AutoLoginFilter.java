package cn.wang.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.dao.UserDao;
import cn.wang.domain.User;
import cn.wang.utils.WebUtils;

public class AutoLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if(request.getSession().getAttribute("user")!=null){
			chain.doFilter(request, response);
			return;
		}
		
		String value = null;
		Cookie cookies[] = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("autologin")) {
				value = cookies[i].getValue();
			}
		}
		if (value != null) {
			String username = value.split("\\.")[0];
			String password = value.split("\\.")[1];
			UserDao dao = new UserDao();
			User user = dao.find(username);
			if (user != null) {
				String dbpassword = user.getPassword();
				if (password.equals(WebUtils.md5(dbpassword))) {
					request.getSession().setAttribute("user", user);
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
