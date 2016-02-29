package cn.wang.dao;

import java.sql.SQLException;

import cn.wang.domain.Department;

public interface DepartmentDao {

	public abstract void add(Department department) throws SQLException;

	public abstract Department find(String id) throws SQLException;

}