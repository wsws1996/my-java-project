package cn.wang.spring.jdbc.template;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class Template {

	public Template() {
	}

	public Template(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(String sql) throws SQLException {
		Connection connection= this.dataSource.getConnection();
		Statement statement=connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}
}
