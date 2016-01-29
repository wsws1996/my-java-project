package cn.com.wangshuang;

import java.lang.reflect.Constructor;

public class Reflect4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class c=Class.forName("cn.com.wangshuang.Person");
		Constructor con= c.getDeclaredConstructor(String.class);
		con.setAccessible(true);
		Object o= con.newInstance("ÀîËÄ");
		System.out.println(o);
	}

}
