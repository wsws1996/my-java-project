package cn.wang.utils;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
			ConvertUtils.register(new DateLocaleConverter(),
					DateLocaleConverter.class);
			@SuppressWarnings("rawtypes")
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(t, name, value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return t;
	}
	public static String makeId() {
		return UUID.randomUUID().toString();
	}
}
