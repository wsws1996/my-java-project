package com.wang.ws.cxf.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wang.ws.cxf.rest.pojo.Student;

/**
 * 学生查询rest
 * 
 * @author wang
 *
 */
public class StudentServiceImpl implements StudentService {

	@Override
	public Student queryStudent(long id) {
		Student student = new Student();
		student.setId(id);
		student.setName("张三");
		student.setBirthday(new Date());
		return student;
	}

	@Override
	public List<Student> queryStudentList(String type) {
		List<Student> list = new ArrayList<Student>();
		Student student1 = new Student();
		student1.setId(10001);
		student1.setName("张三");
		student1.setBirthday(new Date());

		Student student2 = new Student();
		student2.setId(10002);
		student2.setName("李四");
		student2.setBirthday(new Date());

		list.add(student1);
		list.add(student2);
		return list;
	}

}
