package cn.com.wangshuang2;

import java.lang.reflect.Method;

public class Reflect {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class c=Class.forName("cn.com.wangshuang2.Person");
//		Method []methods=c.getMethods();
//		for (Method method : methods) {
//			System.out.println(method);
//		}
		Object obj=c.newInstance();
		Method method=c.getDeclaredMethod("function");
		method.setAccessible(true);
		String o= (String)method.invoke(obj);
		System.out.println(o);
	}

}
/*Declared*/