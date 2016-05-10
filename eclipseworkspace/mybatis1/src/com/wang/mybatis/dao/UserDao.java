package com.wang.mybatis.dao;

import com.wang.mybatis.po.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void findUserList() throws Exception;
}
