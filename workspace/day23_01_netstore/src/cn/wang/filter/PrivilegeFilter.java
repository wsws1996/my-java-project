package cn.wang.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wang.domain.Function;
import cn.wang.domain.Role;
import cn.wang.domain.User;
import cn.wang.service.BussinessService;
import cn.wang.service.impl.BussinessServiceImpl;

public class PrivilegeFilter implements Filter {
	private BussinessService service = new BussinessServiceImpl();
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) resp;
		} catch (Exception e) {
			throw new RuntimeException("no-http request or response");
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("/passport/adminlogin.jsp").forward(request, response);;
			return;
		}
		Set<Function> funs = new HashSet<Function>();
		List<Role> roles = service.findRolesByUser(user);
		for (Role role : roles) {
			List<Function> functions = service.findFunctionsByRole(role);
			funs.addAll(functions);
		}
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		if (queryString != null) {
			uri = uri + "?" + queryString;
		}
		uri = uri.replace(request.getContextPath(), "");
		boolean hasPermission = false;
		for (Function function : funs) {
			if (uri.equals(function.getUri())) {
				hasPermission = true;
				break;
			}
		}
		if (!hasPermission) {
			response.getWriter().write("您没有权限");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {
		
	}

}
