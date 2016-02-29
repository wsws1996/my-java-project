package cn.wang.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import cn.wang.dao.StudentDao;
import cn.wang.domain.Student;
import cn.wang.util.DBCPUtil;

public class StudentDaoImpl implements StudentDao {
	QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void save(Student student) {
		try {
			queryRunner
					.update("insert into students (username,password,gender,hobby,birthday,email,grade) values(?,?,?,?,?,?,?)",
							student.getUsername(), student.getPassword(),
							student.getGender(), student.getHobby(),
							student.getBirthday(), student.getEmail(),
							student.getGrade());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
