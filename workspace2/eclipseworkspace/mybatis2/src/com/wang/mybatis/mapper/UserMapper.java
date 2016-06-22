package com.wang.mybatis.mapper;

import java.util.List;

import com.wang.mybatis.po.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;

	public List<User> findUserByList(String username) throws Exception;

	public void updateUser(User user) throws Exception;
}
