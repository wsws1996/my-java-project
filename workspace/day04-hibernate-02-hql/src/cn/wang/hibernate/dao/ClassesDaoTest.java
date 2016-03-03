package cn.wang.hibernate.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.wang.hibernate.domain.Classes;

public class ClassesDaoTest {
	@Test
	public void testClassesDao() {
		ClassesDao classesDao = new ClassesDao();
		ClassesQuery classesQuery = new ClassesQuery();
		classesQuery.setCurrentPage(1);
		classesQuery.setPageSize(2);
		classesQuery.setName("5959");
		PageResult<Classes> pageResult=classesDao.getPageResult(classesQuery);
		for (Classes classes : pageResult.getRows()) {
			System.out.println(classes.getCid());
		}
	}
}
