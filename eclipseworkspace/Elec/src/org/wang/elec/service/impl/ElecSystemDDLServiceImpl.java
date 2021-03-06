package org.wang.elec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.service.IElecSystemDDLService;

@Service(IElecSystemDDLService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecSystemDDLServiceImpl implements IElecSystemDDLService {

	/**
	 * 数据字典表Dao
	 */
	@Resource(name = IElecSystemDDLDao.SERVICE_NAME)
	IElecSystemDDLDao elecSystemDDLDao;

	/**
	 * @name:findSystemDDLByDistinct
	 * @description:数据字典的首页显示,去掉重复值
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-28
	 * @param: 无
	 * @return List<ElecSystemDDL> 存放数据类型的集合
	 */
	@Override
	public List<ElecSystemDDL> findSystemDDLByDistinct() {
		List<ElecSystemDDL> list = elecSystemDDLDao.findSystemDDLByDistinct();
		return list;
	}

	/**
	 * @name:findSystemDDLByKeyword
	 * @description:以数据类型为条件，查询数据字典
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-30
	 * @param: 无
	 * @return List<ElecSystemDDL> 存放数据字典的集合
	 */
	@Override
	public List<ElecSystemDDL> findSystemDDLByKeyword(String keyword) {
		String condition = "";
		List<Object> paramsList = new ArrayList<Object>();
		if (StringUtils.isNotBlank(keyword)) {
			condition += "and o.keyword=?";
			paramsList.add(keyword);
		}
		Object[] params = paramsList.toArray();

		Map<String, String> orderby = new LinkedHashMap<>();
		orderby.put("o.ddlCode", "asc");
		//启用二级缓存的查询缓存
		List<ElecSystemDDL> list = elecSystemDDLDao
				.findCollectionByConditionNoPageWithCache(condition, params, orderby);
		return list;
	}

	/**
	 * @name:saveSystemDDL
	 * @description:保存数据字典
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-30
	 * @param: ElecSystemDDL VO对象
	 * @return 无
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveSystemDDL(ElecSystemDDL elecSystemDDL) {
		String keyword = elecSystemDDL.getKeywordname();
		String typeflag = elecSystemDDL.getTypeflag();
		String itemnames[] = elecSystemDDL.getItemname();

		if (typeflag != null && typeflag.equals("new")) {
			this.saveDDL(keyword, itemnames);
		} else {
			List<ElecSystemDDL> list = this.findSystemDDLByKeyword(keyword);
			elecSystemDDLDao.deleteObjectByCollection(list);
			this.saveDDL(keyword, itemnames);
		}

	}

	private void saveDDL(String keyword, String[] itemnames) {
		if (itemnames != null && itemnames.length > 0) {
			for (int i = 0; i < itemnames.length; i++) {
				ElecSystemDDL systemDDL = new ElecSystemDDL();
				systemDDL.setKeyword(keyword);
				systemDDL.setDdlCode(i + 1);
				systemDDL.setDdlName(itemnames[i]);
				elecSystemDDLDao.save(systemDDL);
			}
		}
	}

	/**
	 * @name:findDdlNameByKeywordAndDdlCode
	 * @description:使用数据类型和数据项的编号，获取数据项的值
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-02
	 * @param String
	 *            keyword,数据类型 String ddlCode,数据项的编号
	 * @return 数据项的值
	 */

	@Override
	public String findDdlNameByKeywordAndDdlCode(String keyword, String ddlCode) {

		return elecSystemDDLDao
				.findDdlNameByKeywordAndDdlCode(keyword, ddlCode);
	}

	@Override
	/**
	 * @name findDdlCodeByKeywordAndDdlName
	 * @description 使用数据类型和数据项的值，获取数据项的编号
	 * @author wang
	 * @version V1.00
	 * @createDate 2016年4月27日
	 * @param keyword 数据类型
	 * @param ddlName 数据项的值
	 * @return 数据项的编号
	 */
	public String findDdlCodeByKeywordAndDdlName(String keyword, String ddlName) {
		// TODO Auto-generated method stub
		return elecSystemDDLDao
				.findDdlCodeByKeywordAndDdlName(keyword, ddlName);
	}
}
