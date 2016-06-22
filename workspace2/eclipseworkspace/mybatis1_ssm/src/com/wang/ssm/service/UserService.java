package com.wang.ssm.service;

import com.wang.ssm.po.User;

public interface UserService {
	public User findUserById(int id) throws Exception;

	public void saveUser() throws Exception;
}
