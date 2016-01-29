package cn.com.wangshuang;

import java.lang.reflect.Constructor;

public class Reflect2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class c=Class.forName("cn.com.wangshuang.Person");
		//Constructor[] cons= c.getDeclaredConstructors();
		//for (Constructor constructor : cons) {
			//System.out.println(constructor);
		//}
		Constructor cons=c.getConstructor();
		Person p= (Person) cons.newInstance();
		System.out.println("P:"+p);
		p.show();
	}

}
