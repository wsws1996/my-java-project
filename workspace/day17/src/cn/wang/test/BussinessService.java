package cn.wang.test;

import java.sql.SQLException;

import org.junit.Test;

import cn.wang.dao.DepartmentDao;
import cn.wang.dao.PersonDao;
import cn.wang.dao.TeacherDao;
import cn.wang.domain.Department;
import cn.wang.domain.Employee;
import cn.wang.domain.Idcard;
import cn.wang.domain.Person;
import cn.wang.domain.Student;
import cn.wang.domain.Teacher;
import cn.wang.utils.DaoFactory;

public class BussinessService {

	DepartmentDao departmentDao = DaoFactory.getInstance().createDao(
			"cn.wang.dao.impl.DepartmentDaoImpl", DepartmentDao.class);
	TeacherDao teacherDao = DaoFactory.getInstance().createDao(
			"cn.wang.dao.impl.TeacherDaoImpl", TeacherDao.class);
	PersonDao personDao = DaoFactory.getInstance().createDao(
			"cn.wang.dao.impl.PersonDaoImpl", PersonDao.class);

	@Test
	public void addDepartment() throws SQLException {
		Department department = new Department();
		department.setId("1");
		department.setName("开发部");

		Employee e1 = new Employee();
		e1.setId("1");
		e1.setName("aaa");
		e1.setSalary(300);

		Employee e2 = new Employee();
		e2.setId("2");
		e2.setName("aaa");
		e2.setSalary(300);

		department.getEmployees().add(e1);
		department.getEmployees().add(e2);

		departmentDao.add(department);
	}

	@Test
	public void findDepartment() throws SQLException {
		Department department = departmentDao.find("1");
		System.out.println(department.getId());
		System.out.println(department.getName());
		System.out.println(department.getEmployees().size());
	}

	@Test
	public void addTeacher() throws SQLException {
		Teacher teacher = new Teacher();
		teacher.setId("1");
		teacher.setName("张");
		teacher.setSalary(100000);

		Student s1 = new Student();
		s1.setId("1");
		s1.setName("aaa");

		Student s2 = new Student();
		s2.setId("2");
		s2.setName("bbb");

		teacher.getStudents().add(s1);
		teacher.getStudents().add(s2);

		teacherDao.add(teacher);

	}

	@Test
	public void findTeacher() throws SQLException {
		Teacher teacher = teacherDao.find("1");
		System.out.println(teacher.getId());
		System.out.println(teacher.getName());
		System.out.println(teacher.getSalary());
		System.out.println(teacher.getStudents().size());
	}

	@Test
	public void addPerson() throws SQLException {
		Person person = new Person();
		person.setId("1");
		person.setName("aaa");

		Idcard idcard = new Idcard();
		idcard.setId("1");
		idcard.setAddress("hn");
		idcard.setPerson(person);

		person.setIdcard(idcard);

		personDao.add(person);
	}
}
