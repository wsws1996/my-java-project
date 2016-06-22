package com.wang.ssm.dao.old;

import com.wang.ssm.po.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;
}
