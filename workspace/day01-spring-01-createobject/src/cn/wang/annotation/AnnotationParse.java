package cn.wang.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationParse {
	public static void parse() {
		Class class1=Yun.class;
		if (class1.isAnnotationPresent(ClassInfo.class)) {
			ClassInfo classInfo= (ClassInfo) class1.getAnnotation(ClassInfo.class);
			System.out.println(classInfo.name());
		}
		
		Method [] methods= class1.getMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(MethodInfo.class)) {
				MethodInfo methodInfo= (MethodInfo) method.getAnnotation(MethodInfo.class);
				System.out.println(methodInfo.name());
			}
		}
	}
	@Test
	public void test(){
		AnnotationParse.parse();
	}
}
