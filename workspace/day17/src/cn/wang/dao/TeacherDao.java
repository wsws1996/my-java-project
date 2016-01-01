package cn.wang.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;


import cn.wang.domain.Student;
import cn.wang.domain.Teacher;
import cn.wang.utils.JdbcUtil;

public class TeacherDao {
	public void add(Teacher teacher) throws SQLException {

		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

		String sql = "insert into teacher(id,name,salary) values(?,?,?)";

		Object params[] = { teacher.getId(), teacher.getName(),
				teacher.getSalary() };

		queryRunner.update(sql, params);
		Set<Student> set = teacher.getStudents();
		for (Student student : set) {
			sql = "insert into student(id,name) values(?,?)";
			params = new Object[] { student.getId(), student.getName() };
			queryRunner.update(sql, params);

			sql = "insert into teacher_student (teacher_id,student_id) values(?,?)";
			params = new Object[] { teacher.getId(), student.getId() };
			queryRunner.update(sql, params);
		}

	}

	public Teacher find(String id) throws SQLException {

		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

		String sql = "select id,name,salary from teacher where id=?";
		Teacher teacher = queryRunner.query(sql, new BeanHandler<Teacher>(
				Teacher.class), id);

		sql = "select student_id from teacher_student where teacher_id=?";

		List<String> ids = queryRunner.query(sql, new ColumnListHandler<String>("student_id"), id);
		
		sql = "select id,name from student where id = ?";

		Student student = null;

		for (String sid : ids) {
			student = queryRunner.query(sql, new BeanHandler<Student>(
					Student.class), sid);
			teacher.getStudents().add(student);
		}
		return teacher;

	}
}
