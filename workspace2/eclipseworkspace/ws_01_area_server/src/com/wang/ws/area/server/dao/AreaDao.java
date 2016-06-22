package com.wang.ws.area.server.dao;

import java.util.List;

import com.wang.ws.area.server.po.Area;

public interface AreaDao {
	/**
	 *  
	 * @param parentid 区域父节点id
	 * @param start 起始下标
	 * @param pageSize 记录数
	 * @return
	 */
	public List<Area> queryAreaList(String parentid,int start,int pageSize);
}
