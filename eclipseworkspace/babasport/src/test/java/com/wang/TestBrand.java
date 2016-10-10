package com.wang;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.wang.common.junit.SpringJunitTest;
import com.wang.core.bean.product.Brand;
import com.wang.core.query.product.BrandQuery;
import com.wang.core.service.product.BrandService;

public class TestBrand extends SpringJunitTest {

	@Autowired
	private BrandService brandService;

	@Test
	public void testQuery() throws Exception {
		BrandQuery brandQuery = new BrandQuery();

//		brandQuery.setFields("id");
//		brandQuery.setNameLike(true);
//		brandQuery.setName("金");
		brandQuery.orderById(false);
		
		brandQuery.setPageNo(2);
		brandQuery.setPageSize(2);

		List<Brand> brands = brandService.getBrandList(brandQuery);

		for (Brand brand : brands) {
			System.out.println(brand);
		}

	}
}
