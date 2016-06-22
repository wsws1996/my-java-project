package com.wang.ssm.dao.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.ssm.po.Student;
import com.wang.ssm.po.StudentExample;


public class StudentMapperTest {

	private ApplicationContext applicationContext;

	private StudentMapper studentMapper;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/applicationContext.xml", "spring/applicationContext-dao.xml" });
		studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		studentMapper.deleteByPrimaryKey(2);
	}

	@Test
	public void testInsert() {
		Student student=new Student();
		student.setUsername("test");
		studentMapper.insert(student);
	}

	@Test
	public void testSelectByExample() {
		StudentExample studentExample=new StudentExample();
		StudentExample.Criteria criteria=studentExample.createCriteria();
		criteria.andSexEqualTo("男");
		criteria.andUsernameEqualTo("fac8fafa-152b-11e6-b572-38b1db435f53");
		
		List<Student> list=studentMapper.selectByExample(studentExample);
		System.out.println(list.size());
	}

	@Test
	public void testSelectByPrimaryKey() {
		Student student= studentMapper.selectByPrimaryKey(1);
		System.out.println(student);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		Student student=new Student();
		student.setId(3);
		student.setUsername("王五五");
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Student student=studentMapper.selectByPrimaryKey(3);
		student.setUsername("王五");
		studentMapper.updateByPrimaryKey(student);
	}

}
