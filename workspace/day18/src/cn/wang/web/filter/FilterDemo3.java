package cn.wang.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo3 implements Filter {

	private FilterConfig config = null;

	@Override
	public void destroy() {
		System.out.println("filter销毁了");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println(this.config.getInitParameter("xxx"));
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter创建了");
		this.config = filterConfig;
	}
}
