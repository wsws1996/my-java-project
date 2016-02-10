package cn.wang.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import sun.util.logging.resources.logging;

public class MyTestRunner {
	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		Class clazz = Dao1ImplTest.class;
		Method methods[] = clazz.getMethods();
		for (Method method : methods) {
			MyTest myTest = method.getAnnotation(MyTest.class);
			if (myTest != null) {
				long time = myTest.timeout();
				if (time < 0) {

					method.invoke(clazz.newInstance(), null);
				} else {
					long startTime=System.nanoTime();
					method.invoke(clazz.newInstance(), null);
					long endTime=System.nanoTime();
					long costTime=endTime-startTime;
					if (costTime>time) {
						System.out.println(method.getName()+"超时");
					}
				}
			}
		}
	}
}
