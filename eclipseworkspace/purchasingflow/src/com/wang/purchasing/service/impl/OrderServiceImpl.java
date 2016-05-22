package com.wang.purchasing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
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

	@Autowired
	private HistoryService historyService;

	@Autowired
	private IdentityService identityService;

	@Override
	public void saveOrder(String userId, OrderCustom orderCustom) throws Exception {

		String orderId = UUIDBuild.getUUID();

		String businessKey = orderId;

		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");

		identityService.setAuthenticatedUserId(userId);// 启动实例之前使用该行代码

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

			OrderCustom orderCustom = new OrderCustom();

			String processInstanceId = task.getProcessInstanceId();

			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			String businessKey = processInstance.getBusinessKey();

			PurBusOrder purBusOrder = purBusOrderMapper.selectByPrimaryKey(businessKey);

			BeanUtils.copyProperties(purBusOrder, orderCustom);

			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("order", orderCustom);

			taskService.complete(taskId, variables);
		}
	}

	@Override
	public void saveOrderAuditStatus(String taskId, String userId, String orderId, String auditType,
			OrderAuditCustom orderAuditCustom) throws Exception {

		orderAuditCustom.setUserId(userId);

		orderAuditCustom.setId(UUIDBuild.getUUID());
		orderAuditCustom.setAuditType(auditType);
		orderAuditCustom.setOrderId(orderId);
		orderAuditCustom.setCreatetime(new Date());

		purBusOrderAuditMapper.insert(orderAuditCustom);

		Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(userId).singleResult();
		if (task != null) {
			Map<String, Object> variables = new HashMap<String, Object>();

			variables.put("audit", orderAuditCustom);

			taskService.complete(taskId, variables);
		}
	}

	@Override
	public List<OrderCustom> findActivityOrderList() throws Exception {
		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();

		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");

		processInstanceQuery.processDefinitionKey(processDefinitionKey);
		processInstanceQuery.orderByProcessInstanceId().desc();
		List<ProcessInstance> list = processInstanceQuery.list();

		List<OrderCustom> orderList = new ArrayList<OrderCustom>();

		for (ProcessInstance processInstance : list) {
			OrderCustom orderCustom = new OrderCustom();
			String businessKey = processInstance.getBusinessKey();

			PurBusOrder purBusOrder = purBusOrderMapper.selectByPrimaryKey(businessKey);
			BeanUtils.copyProperties(purBusOrder, orderCustom);

			orderCustom.setActivityId(processInstance.getActivityId());

			orderList.add(orderCustom);

		}
		return orderList;
	}

	@Override
	public List<OrderCustom> findFinishedOrderList() throws Exception {

		HistoricProcessInstanceQuery historicProcessInstanceQuery = historyService.createHistoricProcessInstanceQuery();
		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");
		historicProcessInstanceQuery.processDefinitionKey(processDefinitionKey);

		historicProcessInstanceQuery.finished();

		historicProcessInstanceQuery.orderByProcessInstanceEndTime().desc();

		List<HistoricProcessInstance> list = historicProcessInstanceQuery.list();
		List<OrderCustom> orderList = new ArrayList<OrderCustom>();
		for (HistoricProcessInstance historicProcessInstance : list) {
			OrderCustom orderCustom = new OrderCustom();
			String businessKey = historicProcessInstance.getBusinessKey();
			PurBusOrder purBusOrder = purBusOrderMapper.selectByPrimaryKey(businessKey);
			BeanUtils.copyProperties(purBusOrder, orderCustom);
			orderCustom.setProcessInstance_startTime(historicProcessInstance.getStartTime());
			orderCustom.setProcessInstance_endTime(historicProcessInstance.getEndTime());

			orderList.add(orderCustom);
		}

		return orderList;
	}

	@Override
	public List<OrderCustom> findOrderTaskListByPid(String processInstanceId) throws Exception {

		HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();

		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");
		historicTaskInstanceQuery.processDefinitionKey(processDefinitionKey);

		historicTaskInstanceQuery.processInstanceId(processInstanceId);

		historicTaskInstanceQuery.orderByHistoricTaskInstanceStartTime().asc();

		List<HistoricTaskInstance> list = historicTaskInstanceQuery.list();
		// 保证activiti与业务系统的弱耦合
		List<OrderCustom> orderList = new ArrayList<OrderCustom>();
		for (HistoricTaskInstance historicTaskInstance : list) {
			OrderCustom orderCustom = new OrderCustom();
			orderCustom.setTaskId(historicTaskInstance.getId());
			orderCustom.setTaskName(historicTaskInstance.getName());
			orderCustom.setAssignee(historicTaskInstance.getAssignee());
			orderCustom.setTaskDefinitionKey(historicTaskInstance.getTaskDefinitionKey());
			orderCustom.setTask_startTime(historicTaskInstance.getStartTime());
			orderCustom.setTask_endTime(historicTaskInstance.getEndTime());

			orderList.add(orderCustom);
		}

		return orderList;
	}

}
