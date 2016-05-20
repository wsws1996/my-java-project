package com.wang.purchasing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.wang.purchasing.dao.mapper.PurBusOrderAuditMapper;
import com.wang.purchasing.dao.mapper.PurBusOrderMapper;
import com.wang.purchasing.po.PurBusOrder;
import com.wang.purchasing.service.OrderService;
import com.wang.purchasing.util.ResourcesUtil;
import com.wang.purchasing.util.UUIDBuild;
import com.wang.purchasing.vo.OrderAuditCustom;
import com.wang.purchasing.vo.OrderCustom;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private PurBusOrderMapper purBusOrderMapper;

	@Autowired
	private PurBusOrderAuditMapper purBusOrderAuditMapper;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Override
	public void saveOrder(String userId, OrderCustom orderCustom) throws Exception {

		String orderId = UUIDBuild.getUUID();

		String businessKey = orderId;

		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);

		String processinstance_Id = processInstance.getProcessInstanceId();

		orderCustom.setId(orderId);

		orderCustom.setCreatetime(new Date());

		orderCustom.setUserId(userId);

		orderCustom.setProcessinstanceId(processinstance_Id);

		purBusOrderMapper.insert(orderCustom);

	}

	@Override
	public List<OrderCustom> findOrderTaskList(String userId) throws Exception {

		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");

		String assignee = userId;

		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.taskAssignee(assignee);

		taskQuery.processDefinitionKey(processDefinitionKey);

		taskQuery.orderByTaskCreateTime().desc();

		List<Task> list = taskQuery.list();

		List<OrderCustom> orderList = new ArrayList<OrderCustom>();

		for (Task task : list) {
			OrderCustom orderCustom = new OrderCustom();

			String processInstanceId = task.getProcessInstanceId();
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();

			String businessKey = processInstance.getBusinessKey();

			String orderId = businessKey;
			PurBusOrder purBusOrder = purBusOrderMapper.selectByPrimaryKey(orderId);

			BeanUtils.copyProperties(purBusOrder, orderCustom);

			orderCustom.setTaskId(task.getId());

			orderCustom.setTaskDefinitionKey(task.getTaskDefinitionKey());

			orderCustom.setTaskName(task.getName());

			orderCustom.setAssignee(task.getAssignee());

			orderList.add(orderCustom);
		}
		return orderList;
	}

	@Override
	public void saveOrderSubmitStatus(String userId, String taskId) throws Exception {
		Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(userId).singleResult();
		if (task != null) {
			taskService.complete(taskId);
		}
	}

	@Override
	public void saveOrderAuditStatus(String taskId,String userId, String orderId, String auditType, OrderAuditCustom orderAuditCustom)
			throws Exception {

		orderAuditCustom.setUserId(userId);

		orderAuditCustom.setId(UUIDBuild.getUUID());
		orderAuditCustom.setAuditType(auditType);
		orderAuditCustom.setOrderId(orderId);
		orderAuditCustom.setCreatetime(new Date());

		purBusOrderAuditMapper.insert(orderAuditCustom);

		Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(userId).singleResult();
		if (task != null) {
			taskService.complete(taskId);
		}
	}

}
