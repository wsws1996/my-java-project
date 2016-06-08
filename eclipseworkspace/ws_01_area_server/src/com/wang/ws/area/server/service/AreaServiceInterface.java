package com.wang.ws.area.server.service;

/**
 * 区域查询服务接口
 * @author wang
 * 
 */
public interface AreaServiceInterface {
	
	/**
	 * 查询区域
	 * 
	 * areainfo是查询区域条件是xml串，包括
	 * @param parentid 区域父节点id
	 * @param start 起始下标，从1开始
	 * @param end 结束下标
	 * 
	 * 
	 * 
	 * @return 区域查询节点，xml串
	 */
	public String queryArea(String areaInfo);
}
