package cn.wang.spring.jdbc.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StudentDao extends JdbcDaoSupport {
	public void saveStudent(String sql) {
		this.getJdbcTemplate().execute(sql);
	}
}
