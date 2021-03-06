package cn.wang.service;

import cn.wang.domain.User;
import cn.wang.exception.UserExistException;

public interface BusinessService {

	public abstract void registerUser(User user) throws UserExistException;

	public abstract User loginUser(String username, String password);

}