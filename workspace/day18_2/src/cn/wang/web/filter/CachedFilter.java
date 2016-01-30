package cn.wang.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wang.web.Wrappers.BufferResponse;

public class CachedFilter implements Filter {

	private Map<String, byte[]> map = new HashMap<String, byte[]>();

	private BufferResponse bufferResponse;

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
		if (map.containsKey(uri)) {
			response.getOutputStream().write(map.get(uri));
			return;
		} else {
			bufferResponse = new BufferResponse(response);
			chain.doFilter(request, bufferResponse);
			byte[] buffer = bufferResponse.getBuffer();
			map.put(uri, buffer);
			response.getOutputStream().write(buffer);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
