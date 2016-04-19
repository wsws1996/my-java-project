package org.wang.elec.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.axis2.AxisFault;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecSystemDDLDao;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.service.IElecSystemDDLService;
import org.wang.elec.webservice.FindSystemByKeyword;
import org.wang.elec.webservice.FindSystemByKeywordResponse;
import org.wang.elec.webservice.IWebSystemDDLServiceStub;

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
		List<ElecSystemDDL> list = elecSystemDDLDao
				.findCollectionByConditionNoPage(condition, params, orderby);
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

	/** 用于同步总部的数据字典的数据 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveWebService() {
		List<ElecSystemDDL> list = this.findSystemDDLByKeyword("");
		elecSystemDDLDao.deleteObjectByCollection(list);
		try {
			IWebSystemDDLServiceStub iWebSystemDDLServiceStub = new IWebSystemDDLServiceStub(
					"http://127.0.0.1:8080/Elec/services/IWebSystemDDLService?wsdl");

			FindSystemByKeyword findSystemByKeyword = new FindSystemByKeyword();
			// 传递空值表示查询所有findSystemByKeyword.setArgs0("");
			try {
				FindSystemByKeywordResponse byKeywordResponse = iWebSystemDDLServiceStub
						.findSystemByKeyword(findSystemByKeyword);
				org.wang.elec.domain.xsd.ElecSystemDDL[] elecSystemDDL = byKeywordResponse
						.get_return();

				if (elecSystemDDL != null && elecSystemDDL.length > 0) {
					for (int i = 0; i < elecSystemDDL.length; i++) {
						ElecSystemDDL ddl = new ElecSystemDDL();

						org.wang.elec.domain.xsd.ElecSystemDDL ddl2 = elecSystemDDL[i];
						BeanUtils.copyProperties(ddl, ddl2);
						ddl.setSeqID(null);
						elecSystemDDLDao.save(ddl);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
