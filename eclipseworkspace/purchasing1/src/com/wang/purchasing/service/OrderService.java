package com.wang.purchasing.service;

import java.util.List;

import com.wang.purchasing.po.PurBusOrder;
import com.wang.purchasing.po.PurBusOrderAudit;

public interface OrderService {

	// 创建采购单
	public void saveOrder(String userId, PurBusOrder purBusOrder)
			throws Exception;

	// 根据id获取采购单信息
	public PurBusOrder findOrderByid(String id) throws Exception;
    
	//查询待提交的采购单信息
	public List<PurBusOrder> findCreateOrderList() throws Exception;
	// 提交采购单
	public void saveSubmitOrder(String orderId) throws Exception;

	
	// 部门经理审核列表
	public List<PurBusOrder> findFirstAuditList() throws Exception;

	// 部门经理审核提交
	public void saveFirstAuditSubmit(String userId,String orderId,
			PurBusOrderAudit purBusOrderAudit) throws Exception;

	// 总经理审核列表
	public List<PurBusOrder> findSecondAuditList() throws Exception;

	// 总经理审核提交
	public void saveSecondAuditSubmit(String userId,String orderId,
			PurBusOrderAudit purBusOrderAudit) throws Exception;

	// 财务审核列表
	public List<PurBusOrder> findThirdAuditList() throws Exception;

	// 财务审核提交
	public void saveThirdAuditSubmit(String userId,String orderId,
			PurBusOrderAudit purBusOrderAudit) throws Exception;

}
