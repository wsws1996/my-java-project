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
	 * @param taskId
	 *            任务id
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

	/**
	 * 查询当前运行的采购流程
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<OrderCustom> findActivityOrderList() throws Exception;

	/**
	 * 查询已结束的流程实例
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<OrderCustom> findFinishedOrderList() throws Exception;

	/**
	 * 根据流程实例id查询历史任务
	 * 
	 * @param processInstanceId
	 *            流程实例id
	 * @return
	 * @throws Exception
	 */

	public List<OrderCustom> findOrderTaskListByPid(String processInstanceId) throws Exception;

	/**
	 * 结算
	 * @param taskId 当前任务id
	 * @param userId 当前用户id
	 * @throws Exception
	 */
	public void saveSettlement(String taskId, String userId) throws Exception;
	
	/**
	 * 入库
	 * @param taskId 当前任务id
	 * @param userId 当前用户id
	 * @throws Exception
	 */
	public void saveStorage(String taskId, String userId) throws Exception;
	
	/**
	 * 根据候选人查询组任务
	 * @param userId 当前用户id
	 * @return
	 * @throws Exception
	 */
	public List<OrderCustom> findOrderGroupTaskList(String userId) throws Exception;
	
	/**
	 * 拾取任务
	 * @param taskId 任务id
	 * @param candidateUserId 候选人id
	 * @throws Exception
	 */
	public void saveClaimTask(String taskId,String candidateUserId) throws Exception;
}
