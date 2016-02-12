package cn.wang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.dao.CategoryDao;
import cn.wang.domain.Category;
import cn.wang.util.DBCPUtil;

public class CategoryDaoImpl implements CategoryDao {
	private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

	@Override
	public void save(Category category) {
		try {
			queryRunner
					.update("insert into categorys (id,name,description) values(?,?,?)",
							category.getId(), category.getName(),
							category.getDescription());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Category> findAll() {
		try {
			return queryRunner.query("select * from categorys", new BeanListHandler<Category>(Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Category findById(String categoryId) {
		try {
			return queryRunner.query("select * from categorys where id=?", new BeanHandler<Category>(Category.class),categoryId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
