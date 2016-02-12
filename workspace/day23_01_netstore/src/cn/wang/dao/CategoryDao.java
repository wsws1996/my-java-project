package cn.wang.dao;

import java.util.List;

import cn.wang.domain.Category;

public interface CategoryDao {

	void save(Category category);

	List<Category> findAll();

	Category findById(String categoryId);

}
