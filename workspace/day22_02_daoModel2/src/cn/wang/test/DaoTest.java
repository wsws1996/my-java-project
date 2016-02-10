package cn.wang.test;


import cn.wang.dao.CustomerDao;
import cn.wang.dao.StudentDao;
import cn.wang.dao.impl.CustomerDaoImpl;
import cn.wang.dao.impl.StudentDaoImpl;
import cn.wang.domain.Customer;
import cn.wang.domain.Student;

public class DaoTest {

	public static void main(String[] args) {
		/*CustomerDao customerDao = new CustomerDaoImpl();
		StudentDao studentDao=new StudentDaoImpl();
		
		Customer customer=new Customer();
		customer.setName("张三");
		customer.setGender("男");
		customerDao.add(customer);
		
		Student student=new Student();
		student.setBirthday(new Date());
		student.setName("李四");
		studentDao.add(student);*/
		CustomerDao customerDao=new CustomerDaoImpl();
		Customer customer=customerDao.findOne(1);
		System.out.println(customer);
		
		StudentDao studentDao=new StudentDaoImpl();
		Student student=studentDao.findOne(3);
		System.out.println(student);
		
	}

}
