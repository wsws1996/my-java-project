package org.wang.elec.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class LogonUtils {
	/* 验证码 */
	public static boolean checkNumber(HttpServletRequest request) {
		String checkNumber = request.getParameter("checkNumber");
		if (StringUtils.isBlank(checkNumber)) {
			return false;
		}
		String CHECK_NUMBER_KEY = (String) request.getSession().getAttribute(
				"CHECK_NUMBER_KEY");
		if (StringUtils.isBlank(CHECK_NUMBER_KEY)) {
			return false;
		}
		return checkNumber.equalsIgnoreCase(CHECK_NUMBER_KEY);
	}

	/* 记住我 */
	public static void rememberMe(String name, String password,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			//中文支持
			name=URLEncoder.encode(name,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Cookie nameCookie = new Cookie("name", name);
		Cookie passwordCookie = new Cookie("password", password);

		String remeberMe = request.getParameter("remeberMe");
		nameCookie.setPath(request.getContextPath() + "/");
		passwordCookie.setPath(request.getContextPath() + "/");
		if (remeberMe != null && remeberMe.equals("yes")) {
			nameCookie.setMaxAge(7 * 24 * 60 * 60);
			passwordCookie.setMaxAge(7 * 24 * 60 * 60);

		} else {
			nameCookie.setMaxAge(0);
			passwordCookie.setMaxAge(0);
		}
		response.addCookie(nameCookie);
		response.addCookie(passwordCookie);
	}

}
