package cn.wang.spring.aop.xml.stest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wang.proxy.salary.Privilege;
import cn.wang.proxy.salary.SalaryManager;
import cn.wang.spring.xml.transaction.PersonDao;

public class STest {
	@Test
	public void STest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Privilege privilege = (Privilege) applicationContext.getBean("privilege");
		privilege.setAccess("admin");
		SalaryManager salaryManager=(SalaryManager) applicationContext.getBean("salaryManager");
		salaryManager.showSalary();
	}
}
