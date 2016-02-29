package cn.wang.hibernate.db;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CreateTable {
	@Test
	public void testCreateTable(){
		Configuration configuration=new Configuration();
		configuration.configure();
		configuration.buildSessionFactory();
	}
}
