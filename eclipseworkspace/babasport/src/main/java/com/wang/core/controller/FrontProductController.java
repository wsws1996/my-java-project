package com.wang.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.core.bean.product.Brand;
import com.wang.core.bean.product.Color;
import com.wang.core.bean.product.Feature;
import com.wang.core.bean.product.Product;
import com.wang.core.bean.product.Sku;
import com.wang.core.bean.product.Type;
import com.wang.core.query.product.BrandQuery;
import com.wang.core.query.product.FeatureQuery;
import com.wang.core.query.product.ProductQuery;
import com.wang.core.query.product.TypeQuery;
import com.wang.core.service.product.BrandService;
import com.wang.core.service.product.FeatureService;
import com.wang.core.service.product.ProductService;
import com.wang.core.service.product.SkuService;
import com.wang.core.service.product.TypeService;

import cn.itcast.common.page.Pagination;

/**
 * 前台商品列表 测试 商品详情页面
 * 
 * @author wang
 *
 */
@Controller
public class FrontProductController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private FeatureService featureService;

	// 商品列表页面
	@RequestMapping(value = "/product/display/list.shtml")
	public String list(Integer pageNo, Integer brandId, String brandName, Integer typeId, String typeName,
			ModelMap model) {

		// 加载商品属性
		FeatureQuery featureQuery = new FeatureQuery();

		List<Feature> features = featureService.getFeatureList(featureQuery);
		// 显示在页面
		model.addAttribute("features", features);

		// 分页参数
		StringBuilder params = new StringBuilder();

		// 设置页号
		ProductQuery productQuery = new ProductQuery();
		productQuery.setPageNo(Pagination.cpn(pageNo));
		// 设置每页数
		productQuery.setPageSize(Product.FRONT_PAGE_SIZE);
		// 设置ID倒排
		productQuery.orderbyId(false);
		// 隐藏已选条件
		boolean flag = false;
		// 条件Map窗口
		Map<String, String> query = new LinkedHashMap<String, String>();
		// 品牌ID
		if (null != brandId) {
			productQuery.setBrandId(brandId);
			flag = true;
			model.addAttribute("brandId", brandId);
			model.addAttribute("brandName", brandName);
			query.put("品牌", brandName);
			params.append("&").append("brandId=").append(brandId).append("&brandName=").append(brandName);
		} else {
			// 加载商品品牌
			BrandQuery brandQuery = new BrandQuery();

			brandQuery.setFields("id,name");
			brandQuery.setIsDisplay(1);
			// 加载品牌
			List<Brand> brands = brandService.getBrandList(brandQuery);
			// 显示在页面
			model.addAttribute("brands", brands);
		}
		// 类型ID
		if (null != typeId) {
			productQuery.setTypeId(typeId);
			flag = true;
			model.addAttribute("typeId", typeId);
			model.addAttribute("typeName", typeName);
			params.append("&").append("typeId=").append(typeId).append("&typeName=").append(typeName);
			query.put("类型", typeName);
		} else {
			// 加载商品类型
			TypeQuery typeQuery = new TypeQuery();
			// 指定查询哪些字段
			typeQuery.setFields("id,name");
			typeQuery.setIsDisplay(1);
			typeQuery.setParentId(0);
			List<Type> types = typeService.getTypeList(typeQuery);
			// 显示在页面
			model.addAttribute("types", types);
		}
		model.addAttribute("flag", flag);
		model.addAttribute("query", query);
		Pagination pagination = productService.getProductListWithPage(productQuery);

		// 分页页面显示
		String url = "/product/display/list.shtml";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		return "product/product";
	}

	@RequestMapping(value = "/test/springmvc.do")
	public String test(String name, Date birthday) {
		System.out.println(name + ":" + birthday);
		return "";
	}

	// 跳转商品详情页
	@RequestMapping(value = "/product/detail.shtml")
	public String detail(Integer id, ModelMap model) {
		// 商品加载
		Product product = productService.getProductByKey(id);

		model.addAttribute("product", product);

		// skus
		List<Sku> skus = skuService.getStock(id);
		model.addAttribute("skus", skus);
		// 去重复
		List<Color> colors = new ArrayList<Color>();
		// 遍历Sku
		for (Sku sku : skus) {
			// 判断集合中是否已经有此颜色对象了
			if (!colors.contains(sku.getColor())) {
				colors.add(sku.getColor());
			}
		}
		model.addAttribute("colors", colors);
		return "product/productDetail";
	}

	@Autowired
	private SkuService skuService;

	// @InitBinder
	// public void initBinder(WebDataBinder binder, WebRequest request) {
	// 转换日期格式
	// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	// true));
	// }
}
