package cn.wang.test;

import java.util.Date;

import cn.wang.dao.CustomerDao;
import cn.wang.dao.StudentDao;
import cn.wang.dao.impl.CustomerDaoImpl;
import cn.wang.dao.impl.StudentDaoImpl;
import cn.wang.domain.Customer;
import cn.wang.domain.Student;

public class DaoTest {

	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDaoImpl();
		StudentDao studentDao=new StudentDaoImpl();
		
		Customer customer=new Customer();
		customer.setName("张三");
		customer.setGender("男");
		customerDao.add(customer);
		
		Student student=new Student();
		student.setBirthday(new Date());
		student.setName("李四");
		studentDao.add(student);
	}

}
