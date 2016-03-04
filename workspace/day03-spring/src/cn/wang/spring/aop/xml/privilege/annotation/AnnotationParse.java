package cn.wang.spring.aop.xml.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {
	public static String parse(Class targetClass, String methodName)
			throws NoSuchMethodException, SecurityException {
		String methodAccess = "";
		Method method = targetClass.getMethod(methodName);
		if (method.isAnnotationPresent(PrivilegeInfo.class)) {
			PrivilegeInfo privilegeInfo = method
					.getAnnotation(PrivilegeInfo.class);
			methodAccess = privilegeInfo.name();
		}
		return methodAccess;
	}
}
