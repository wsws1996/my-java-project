package cn.test.wangshuang4;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDaoImpl();
//		ud.add();
//		ud.delete();
//		ud.update();
//		ud.find();
		System.out.println("-------------------");
		MyInvocationHandler handler=new MyInvocationHandler(ud);
		UserDao uDao=(UserDao)Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), handler);
//		uDao.add();
//		uDao.delete();
		Student stu=new Studentimpl();
		MyInvocationHandler han=new MyInvocationHandler(stu);
		Student student=(Student)Proxy.newProxyInstance(stu.getClass().getClassLoader(), stu.getClass().getInterfaces(), han);
		student.regist();
		student.login();
	}

}
