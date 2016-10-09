package com.wang.core.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.core.bean.product.Brand;
import com.wang.core.dao.product.BrandDao;

import cn.itcast.common.page.Pagination;

/**
 * 品牌事务
 * 
 * @author wang
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Resource
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand) {
		// 1.起始行 startRow = (pageNo - 1)*pageSize
		// 2.每页数
		// 3.总记录数
		Pagination pagination = new Pagination(brand.getPageNo(), brand.getPageSize(), brandDao.getBrandCount(brand));
		// Brand集合
		pagination.setList(brandDao.getBrandListWithPage(brand));

		return pagination;
	}

	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}

	public void deleteBrandByKey(Integer id) {
		brandDao.deleteBrandByKey(id);
	}

	public void deleteBrandByKeys(Integer[] ids) {
		brandDao.deleteBrandByKeys(ids);
	}

	public void updateBrandByKey(Brand brand) {
		brandDao.updateBrandByKey(brand);
	}
}
