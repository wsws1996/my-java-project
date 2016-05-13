package com.wang.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import com.wang.mybatis.po.Orders;
import com.wang.mybatis.po.OrdersCustom;
import com.wang.mybatis.po.User;

public class OrdersMapperCustomTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
	}

	@Test
	public void testFindOrderUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list = ordersMapperCustom.findOrderUserList();
		for (OrdersCustom ordersCustom : list) {
			System.out.println(ordersCustom);
		}
		System.out.println("size:::" + list.size());
	}

	@Test
	public void testFindOrderUserListResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrderUserListResultMap();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		System.out.println("size:::" + list.size());

	}

	@Test
	public void testFindOrdersUserDetailList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserDetailList();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		System.out.println("size:::" + list.size());

	}

	@Test
	public void testFindOrdersUserDetailItemList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserDetailItemList();
		for (Orders orders : list) {
			System.out.println(orders);
		}
		System.out.println("size:::" + list.size());

	}

	@Test
	public void testFindOrdersList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersList();
		for (Orders orders : list) {
			System.out.println(orders.getId());
			System.out.println(orders.getUser());
		}
		System.out.println("size:::" + list.size());
	}

	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.findUserById(10);

		System.out.println(user);

		// User user_update = new User();
		//
		// user_update.setId(10);
		// user_update.setUsername("中学生");
		// userMapper.updateUser(user_update);
		// sqlSession.commit();

		User user2 = userMapper.findUserById(10);
		System.out.println(user2);
	}

	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);

		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

//		SqlSession sqlSession3 = sqlSessionFactory.openSession();
//		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

		User user1 = userMapper1.findUserById(10);
		System.out.println(user1);
		sqlSession1.close();

//		User user_update = new User();
//
//		user_update.setId(10);
//		user_update.setUsername("张一三");
//		userMapper3.updateUser(user_update);
//		sqlSession3.commit();
//		sqlSession3.close();

		User user2 = userMapper2.findUserById(10);
		System.out.println(user2);
		sqlSession2.close();

		System.out.println("equal:" + user1.equals(user2));
	}
}
