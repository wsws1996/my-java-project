package com.wang.purchasing.service;

import java.util.List;

import com.wang.purchasing.vo.OrderAuditCustom;
import com.wang.purchasing.vo.OrderCustom;

public interface OrderService {

	/**
	 * 
	 * @param userId
	 *            当前用户id
	 * @param orderCustom
	 *            填写采购信息
	 * @throws Exception
	 */
	public void saveOrder(String userId, OrderCustom orderCustom) throws Exception;

	/**
	 * 
	 * @param userId
	 *            当前用户的id
	 * @return List<OrderCustom> OrderCustom包括采购单信息和activiti的任务信息
	 * @throws Exception
	 */
	public List<OrderCustom> findOrderTaskList(String userId) throws Exception;

	/**
	 * 
	 * @param userId
	 *            当前用户id
	 * @param taskId
	 *            完成任务id
	 * @throws Exception
	 */
	public void saveOrderSubmitStatus(String userId, String taskId) throws Exception;

	/**
	 * @param taskId 任务id
	 * @param userId
	 *            当前用户id
	 * @param orderId
	 *            采购单id
	 * @param auditType
	 *            审核类型(firstAudit,secondAudit,thridAudit)
	 * @param orderAuditCustom
	 * @throws Exception
	 */
	public void saveOrderAuditStatus(String taskId, String userId, String orderId, String auditType,
			OrderAuditCustom orderAuditCustom) throws Exception;
}
