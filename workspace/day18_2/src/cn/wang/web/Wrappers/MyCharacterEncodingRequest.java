package cn.wang.web.Wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyCharacterEncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public MyCharacterEncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		try {
			String value = this.request.getParameter(name);
			if (value == null) {
				return null;
			}
			if (!this.request.getMethod().equalsIgnoreCase("get")) {
				return value;
			}

//			value = new String(value.getBytes("ISO8859-1"),
//					this.getCharacterEncoding());
			/*
			 * tomcat8.0可能已可以自动完成GET请求的UTF-8编码，不再需要以上语句
			 */
			return value;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
