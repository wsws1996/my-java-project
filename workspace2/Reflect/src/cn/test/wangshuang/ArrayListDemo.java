package cn.test.wangshuang;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList <Integer>array=new ArrayList<Integer>();
		array.add(45);
//		array.add(10);
//		array.add("sd");
//		System.out.println(array);
		Class c=array.getClass();
		Method m=c.getDeclaredMethod("add",Object.class);
		m.invoke(array, "hello");
		m.invoke(array, "world");
		m.invoke(array, "java");
		System.out.println(array);
	}

}
