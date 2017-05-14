package com.shopping.service;

import com.shopping.pojo.TbUser;

public interface UserService {
	public TbUser getUserByToken(String token);
}
