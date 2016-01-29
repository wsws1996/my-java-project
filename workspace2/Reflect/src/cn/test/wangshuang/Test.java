package cn.test.wangshuang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Student s=new Student();
//		s.love();
//		Teacher t=new Teacher();
//		t.love();
		Properties prop=new Properties();
		FileReader fr=new FileReader("class.txt");
		prop.load(fr);
		fr.close();
		String className=prop.getProperty("className");
		String methodName=prop.getProperty("methodName");
		Class c=Class.forName(className);
		Constructor con=c.getConstructor();
		Object obj=con.newInstance();
		Method method=c.getDeclaredMethod(methodName);
		method.invoke(obj);
		
	}

}
