package cn.wang.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.domain.Privilege;
import cn.wang.domain.User;
import cn.wang.service.SecurityService;

public class CheckPrivilegeFilter implements Filter {

	private Map<String, Privilege> map = new HashMap<String, Privilege>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		Privilege privilege = map.get(uri);
		if (privilege == null) {
			chain.doFilter(request, response);
			return;
		}
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("message", "对不起，请登录后再来");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		SecurityService service = new SecurityService();
		Set<Privilege> privileges = service.getUserAllPrivileges(user.getId());
		if (!privileges.contains(privilege)) {
			request.setAttribute("message", "对不起，您没有权限访问，请联系管理员");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		map.put("/day19/servlet/AddProduct", new Privilege("添加商品"));
		map.put("/day19/servlet/UpdateProduct", new Privilege("修改商品"));
		map.put("/day19/servlet/DeleteProduct", new Privilege("删除商品"));
	}

}
