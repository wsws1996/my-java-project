package com.wang.ssm.dao.mapper;

import com.wang.ssm.po.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;

	public void updateUser(User user) throws Exception;

	public void insertUser(User user) throws Exception;
}
