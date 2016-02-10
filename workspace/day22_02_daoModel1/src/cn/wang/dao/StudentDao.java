package cn.wang.dao;

import java.util.List;

import cn.wang.domain.Student;

public interface StudentDao extends Dao<Student> {

	List<Student> findAll();
}
