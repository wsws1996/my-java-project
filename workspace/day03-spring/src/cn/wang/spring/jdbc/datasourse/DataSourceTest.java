package cn.wang.spring.jdbc.datasourse;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {
	@Test
	public void test() throws SQLException{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource= (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
		
		
	}
}
