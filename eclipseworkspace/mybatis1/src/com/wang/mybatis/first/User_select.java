package com.wang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.mybatis.po.User;

public class User_select {
	public static void main(String[] args) throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		List<User> list = sqlSession.selectList("findUserByList", "fa");
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
}
