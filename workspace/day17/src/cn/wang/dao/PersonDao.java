package cn.wang.dao;

import java.sql.SQLException;

import cn.wang.domain.Person;

public interface PersonDao {

	public abstract void add(Person person) throws SQLException;

}