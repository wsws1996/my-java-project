package cn.wang.dao;

import java.util.List;

import cn.wang.db.MyDb;
import cn.wang.domain.User;

public class UserDao {
	public User find(String username, String password) {
		List<User> list = MyDb.getAll();
		for (User user : list) {
			if (user.getUsername().equals(username)
					&& user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User find(String username) {
		List<User> list = MyDb.getAll();
		for (User user : list) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
