package cn.wang.db;

import java.util.ArrayList;
import java.util.List;

import cn.wang.domain.User;

public class MyDb {
	private static List<User> list = new ArrayList<User>();
	static{
		list.add(new User("aaa", "123"));
		list.add(new User("ccc", "123"));
		list.add(new User("bbb", "123"));
	}
	public static List<User> getAll() {
		return list;
	}
}
