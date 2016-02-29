package cn.wang.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;


import cn.wang.domain.User;
import cn.wang.utils.JdbcUtil;

public class Demo1 {

	@Test
	public void add() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into user(name,password,email,birthday) values(?,?,?,?)";
		Object params[] = { "ccc", "123", "cc@sina.com", "1989-09-09" };
		queryRunner.update(sql, params);
	}

	@Test
	public void delete() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "delete from user where id=?";
		queryRunner.update(sql, 1);

	}

	@Test
	public void update() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "update user set name =? where id=?";
		Object params[] = { "ddd", 5 };
		queryRunner.update(sql, params);
	}

	@Test
	public void find() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user where id=?";
		User user = queryRunner
				.query(sql, new BeanHandler<User>(User.class), 2);
		System.out.println(user.getEmail());
	}

	@Test
	public void getAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<User> list = queryRunner.query(sql, new BeanListHandler<User>(
				User.class));
		System.out.println(list.size());

	}

	@Test
	public void testBatch() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into user(name,password,email,birthday) values(?,?,?,?)";
		Object params[][] = new Object[10][];
		for (int i = 0; i < 10; i++) {
			params[i] = new Object[] { "aa", "123", "aa@sina.com", new Date() };
		}
		queryRunner.batch(sql, params);
	}

	@Test
	public void testclob() throws SQLException, IOException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into testclob(resume) values(?)";
		String path = Demo1.class.getClassLoader().getResource("1.txt")
				.getPath();
		FileReader fileReader = new FileReader(path);
		char buffer[] = new char[(int) new File(path).length()];
		fileReader.read(buffer);
		fileReader.close();
		SerialClob serialClob = new SerialClob(buffer);
		Object params[] = { serialClob };
		queryRunner.update(sql, params);

	}
}
