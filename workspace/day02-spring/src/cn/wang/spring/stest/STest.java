package cn.wang.spring.stest;

import java.lang.reflect.Proxy;

import org.junit.Test;

import cn.wang.proxy.salary.Logger;
import cn.wang.proxy.salary.MyInterceptor;
import cn.wang.proxy.salary.Privilege;
import cn.wang.proxy.salary.SalaryManager;
import cn.wang.proxy.salary.SalaryManagerImpl;
import cn.wang.proxy.salary.Security;

public class STest {
	@Test
	public void STest() {
		SalaryManager target = new SalaryManagerImpl();
		Logger logger = new Logger();
		Security security = new Security();
		Privilege privilege = new Privilege();
		privilege.setAccess("db");
		MyInterceptor myInterceptor = new MyInterceptor(target, logger,
				security, privilege);
		SalaryManager salaryManager= (SalaryManager) Proxy.newProxyInstance(target.getClass().getClassLoader(), target
				.getClass().getInterfaces(), myInterceptor);
		salaryManager.showSalary();
	}
}
