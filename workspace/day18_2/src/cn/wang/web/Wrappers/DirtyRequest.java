package cn.wang.web.Wrappers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DirtyRequest extends HttpServletRequestWrapper {

	private List<String> dirtyWords = Arrays.asList("傻B", "操蛋", "畜生","共匪","TM");
	private HttpServletRequest request;

	public DirtyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {

		String value = this.request.getParameter(name);

		if (value == null) {
			return null;
		}

		for (String dirtyWord : dirtyWords) {
			if (value.contains(dirtyWord)) {
				value = value.replace(dirtyWord, "****");
			}
		}

		return value;
	}

}
