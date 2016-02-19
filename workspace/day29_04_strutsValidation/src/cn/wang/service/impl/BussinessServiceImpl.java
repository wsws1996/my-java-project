package cn.wang.service.impl;

import cn.wang.dao.StudentDao;
import cn.wang.dao.impl.StudentDaoImpl;
import cn.wang.domain.Student;
import cn.wang.service.BussinessService;

public class BussinessServiceImpl implements BussinessService {
	private StudentDao studentDao=new StudentDaoImpl();
	@Override
	public void registerStudent(Student student) {
		studentDao.save(student);
	}

}
