package com.wang.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.core.bean.product.Brand;
import com.wang.core.service.product.BrandService;

import cn.itcast.common.page.Pagination;

/**
 * 品牌
 * 
 * @author wang
 *
 */
@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	// 品牌列表页面
	@RequestMapping(value = "/brand/list.do")
	public String list(String name, Integer isDisplay, Integer pageNo, ModelMap model) {
		// 参数
		StringBuilder params = new StringBuilder();
		Brand brand = new Brand();
		// 判断传进来的名称是否为null并判断是否为空串
		if (null != name && StringUtils.isNotBlank(name)) {
			brand.setName(name);
			params.append("name=").append(name);
		}
		if (null != isDisplay) {
			brand.setIsDisplay(isDisplay);
			params.append("&").append("isDisplay=").append(isDisplay);
		} else {
			brand.setIsDisplay(1);
			params.append("&").append("isDisplay=").append(1);
		}
		// 页号
		// 如果页号为null或小于1，置为1
		brand.setPageNo(Pagination.cpn(pageNo));

		// 每页数
		brand.setPageSize(5);

		// 分页对象
		Pagination pagination = brandService.getBrandListWithPage(brand);

		// 分页展示
		String url = "/brand/list.do";
		pagination.pageView(url, params.toString());

		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		return "brand/list";
	}

	// 跳转品牌添加页面
	@RequestMapping(value = "/brand/toAdd.do")
	public String toAdd() {
		return "brand/add";
	}

	// 添加品牌
	@RequestMapping(value = "/brand/add.do")
	public String add(Brand brand) {
		// 添加开始
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}

	// 删除一个品牌
	@RequestMapping(value = "/brand/delete.do")
	public String delete(Integer id, String name, Integer isDisplay, ModelMap model) {

		brandService.deleteBrandByKey(id);
		if (StringUtils.isNotBlank(name)) {
			model.addAttribute("name", name);
		}
		if (null != isDisplay) {
			model.addAttribute("isDisplay", isDisplay);
		}

		return "redirect:/brand/list.do";
	}

	// 删除多个品牌
	@RequestMapping(value = "/brand/deletes.do")
	public String deletes(Integer[] ids, String name, Integer isDisplay, ModelMap model) {

		brandService.deleteBrandByKeys(ids);
		if (StringUtils.isNotBlank(name)) {
			model.addAttribute("name", name);
		}
		if (null != isDisplay) {
			model.addAttribute("isDisplay", isDisplay);
		}

		return "redirect:/brand/list.do";
	}

	// 去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Integer id, ModelMap model) {
		Brand brand = brandService.getBrandByKey(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}

	@RequestMapping(value = "/brand/edit.do")
	public String edit(Brand brand, ModelMap model) {
		brandService.updateBrandByKey(brand);
		return "redirect:/brand/list.do";
	}
}
