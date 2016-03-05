package cn.wang.spring.jdbc.template;

import java.sql.SQLException;

public class StudentDao extends Template{
	public void saveStudent() throws SQLException {
		this.insert("insert into Student(name,description) values('aa','aa')");
	}
}
