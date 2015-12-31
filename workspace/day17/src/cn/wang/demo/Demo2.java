package cn.wang.demo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.wang.utils.JdbcUtil;

public class Demo2 {

	@Test
	public void testArrayHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		Object result[] = queryRunner.query(sql, new ArrayHandler());
		System.out.println(Arrays.asList(result));
	}

	@Test
	public void testArrayListHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
		for (Object[] object : list) {
			System.out.println(Arrays.asList(object));
		}
	}

	@Test
	public void testColumnListHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<String> list = queryRunner.query(sql,
				new ColumnListHandler<String>("id"));
		System.out.println(list);
	}

	@Test
	public void testKeyedHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		Map<Integer, Map<String, Object>> map = queryRunner.query(sql,
				new KeyedHandler<Integer>("id"));
		for (Map.Entry<Integer, Map<String, Object>> me : map.entrySet()) {
			int id = me.getKey();
			System.out.println(id);
			Map<String, Object> innerMap = me.getValue();
			for (Map.Entry<String, Object> innerme : innerMap.entrySet()) {
				String columnName = innerme.getKey();
				Object value = innerme.getValue();
				System.out.println(columnName + ":" + value);
			}
			System.out.println("----------");

		}
	}

	@Test
	public void testMapHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		Map<String, Object> map = queryRunner.query(sql, new MapHandler());
		for (Map.Entry<String, Object> me : map.entrySet()) {
			System.out.println(me.getKey() + ":" + me.getValue());
		}
	}

	@Test
	public void testMapListHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<Map<String, Object>> list = queryRunner.query(sql,
				new MapListHandler());
		for (Map<String, Object> map : list) {

			for (Map.Entry<String, Object> me : map.entrySet()) {
				System.out.println(me.getKey() + ":" + me.getValue());
			}
		}
	}

	@Test
	public void testScalarHandler() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select count(*) from user";
		long l = (long) queryRunner.query(sql, new ScalarHandler<Long>(1));
		int count = (int) l;
		System.out.println(count);
	}
}
