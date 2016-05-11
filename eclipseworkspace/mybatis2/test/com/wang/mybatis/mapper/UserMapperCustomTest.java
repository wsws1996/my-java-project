package com.wang.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wang.mybatis.po.QueryVo;
import com.wang.mybatis.po.User;

public class UserMapperCustomTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
	}

	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapperCustom userMapperCustom = sqlSession.getMapper(UserMapperCustom.class);

		User user = new User();
		user.setUsername("fa4bdb55-152b-11e6-b572-38b1db435f53");
		// user.setSex("男");

		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);
		List<User> list = userMapperCustom.findUserList(queryVo);
		for (User user2 : list) {
			// System.out.println(user2);
		}
	}

	@Test
	public void findUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapperCustom userMapperCustom = sqlSession.getMapper(UserMapperCustom.class);

		User user = new User();
		// user.setUsername("fa4bdb55-152b-11e6-b572-38b1db435f53");
		user.setSex("男");

		QueryVo queryVo = new QueryVo();

		queryVo.setIds(new int[] { 1, 3, 4, 10, 58 });
		queryVo.setUser(user);
		int count = userMapperCustom.findUserCount(queryVo);
		System.out.println("ccc:" + count);
	}

	@Test
	public void findUserListReturnMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapperCustom userMapperCustom = sqlSession.getMapper(UserMapperCustom.class);

		User user = new User();
		user.setUsername("fa4bdb55-152b-11e6-b572-38b1db435f53");
		user.setSex("男");

		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);
		Map map = userMapperCustom.findUserListReturnMap(queryVo);
		for (Object e : map.entrySet()) {
			Map.Entry entry = (Entry) e;
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	@Test
	public void findUserListResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapperCustom userMapperCustom = sqlSession.getMapper(UserMapperCustom.class);

		User user = new User();
		// user.setUsername("fa4bdb55-152b-11e6-b572-38b1db435f53");
		user.setSex("男");

		QueryVo queryVo = new QueryVo();

		queryVo.setIds(new int[] { 1, 3, 4, 10, 58 });
		queryVo.setUser(user);
		List<User> list=userMapperCustom.findUserListResultMap(queryVo);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
}
