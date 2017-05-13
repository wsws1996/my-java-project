package com.shopping.service;

import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbUser;

public interface UserService {
	public ShoppingResult checkData(String content, Integer type);

	public ShoppingResult createUser(TbUser user);

	public ShoppingResult userLogin(String username, String password);

	public ShoppingResult getUserByToken(String token);
}
