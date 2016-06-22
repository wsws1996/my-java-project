package com.wang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class User_delete {
	public static void main(String[] args) throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		
		
		sqlSession.delete("test.deleteUser", 50);
		sqlSession.commit();
		sqlSession.close();
	}
}
