package org.wang.elec.webservice;

import java.util.List;

import org.wang.elec.domain.ElecSystemDDL;

public interface IWebSystemDDLService {
	/**
	 * 
	 * @param keyword 传递的数据类型
	 * @return List<ElecSystemDDL> 根据传递的数据类型，查询该数据类型对应的结果
	 */
	public List<ElecSystemDDL> findSystemByKeyword(String keyword);
}
