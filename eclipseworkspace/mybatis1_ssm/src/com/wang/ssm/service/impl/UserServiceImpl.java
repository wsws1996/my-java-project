package com.wang.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wang.ssm.dao.mapper.UserMapper;
import com.wang.ssm.po.User;
import com.wang.ssm.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserById(int id) throws Exception {
			return userMapper.findUserById(10);
	}

	@Override
	public void saveUser() throws Exception {
		User user_update =new User();
		user_update.setId(10);
		user_update.setUsername("张三");
		userMapper.updateUser(user_update);
		
		User user_insert=new User();
		user_insert.setUsername("王五");
		userMapper.insertUser(user_insert);
	}

}
