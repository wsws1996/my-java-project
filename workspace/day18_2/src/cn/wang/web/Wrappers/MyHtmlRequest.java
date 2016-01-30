package cn.wang.web.Wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHtmlRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public MyHtmlRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {

		String value = this.request.getParameter(name);
		if (value == null) {
			return null;
		}

		return filter(value);
	}

	public String filter(String message) {

		if (message == null)
			return (null);

		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());

	}

}
