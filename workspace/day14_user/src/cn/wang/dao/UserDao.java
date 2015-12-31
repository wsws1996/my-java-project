package cn.wang.dao;

import cn.wang.domain.User;

public interface UserDao {

	public abstract User find(String username, String password);

	public abstract void add(User user);

	public abstract User find(String username);

}