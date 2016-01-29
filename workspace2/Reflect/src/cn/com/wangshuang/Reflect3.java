package cn.com.wangshuang;

import java.lang.reflect.Constructor;

public class Reflect3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class c=Class.forName("cn.com.wangshuang.Person");
		Constructor con=c.getConstructor(String.class,int.class,String.class);
		Object o=con.newInstance("李四",23,"北京");
		System.out.println(o);
	}

}
