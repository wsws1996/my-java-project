package com.wang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wang.mybatis.po.User;

public class User_insert {
	public static void main(String[] args) throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		
		User user=new User();
		user.setUsername("小章");
		user.setScore(78.9f);
		user.setAddress("河南");
		user.setBirthday(new Date());
		sqlSession.insert("test.insertUser", user);
		System.out.println("id========*&"+user.getId());
		sqlSession.commit();
		sqlSession.close();
	}
}
