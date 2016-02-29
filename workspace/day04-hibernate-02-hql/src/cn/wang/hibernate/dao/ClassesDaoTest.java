package cn.wang.hibernate.dao;

import java.util.List;

import org.junit.Test;

import cn.wang.hibernate.domain.Classes;

public class ClassesDaoTest {
	@Test
	public void testClassesDao(){
		ClassesDao classesDao=new ClassesDao();
		Long count=classesDao.getCount();
		System.out.println(count);
	}
}
