package org.wang.crm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.crm.domain.Department;
import org.wang.crm.service.DepartmentService;

public class DepartmentTest {
	@Test
	public void testSaveDepartment(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		DepartmentService departmentService =(DepartmentService) applicationContext.getBean("departmentService");
		Department department=new Department();
		department.setName("技术部");
		departmentService.saveEntry(department);
	}
}
