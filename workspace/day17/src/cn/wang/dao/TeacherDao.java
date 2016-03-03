package cn.wang.dao;

import java.sql.SQLException;

import cn.wang.domain.Teacher;

public interface TeacherDao {

	public abstract void add(Teacher teacher) throws SQLException;

	public abstract Teacher find(String id) throws SQLException;

}