package cn.wang.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestRunner {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = Dao1ImplTest.class;
		Method methods[] = clazz.getMethods();
		for (Method method : methods) {
			boolean b = method.isAnnotationPresent(MyTest.class);
			if (b) {
				method.invoke(clazz.newInstance(), null);
			}
		}
	}
}
