package cn.wang.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.dao.TeacherDao;
import cn.wang.domain.Student;
import cn.wang.domain.Teacher;
import cn.wang.utils.JdbcUtil;

public class TeacherDaoImpl implements TeacherDao {
	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.TeacherDao#add(cn.wang.domain.Teacher)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.TeacherDao#find(java.lang.String)
	 */
	@Override
	public Teacher find(String id) throws SQLException {

		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

		String sql = "select id,name,salary from teacher where id=?";
		Teacher teacher = queryRunner.query(sql, new BeanHandler<Teacher>(
				Teacher.class), id);

		sql = "select s.id,s.name from teacher_student t_s, student s where t_s.teacher_id=? and t_s.student_id=s.id";
		List<Student> list = queryRunner.query(sql,
				new BeanListHandler<Student>(Student.class), id);

		teacher.getStudents().addAll(list);

		return teacher;

	}
}
