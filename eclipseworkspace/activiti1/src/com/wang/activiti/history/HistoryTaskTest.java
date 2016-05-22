package com.wang.activiti.history;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.junit.Test;

import com.wang.activiti.vo.OrderCustom;

public class HistoryTaskTest {

	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void queryHistoryTask() {
		HistoryService historyService = processEngine.getHistoryService();

		HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();

		String processDefinitionKey = "purchasingflow";
		historicTaskInstanceQuery.processDefinitionKey(processDefinitionKey);

		String processInstanceId = "5901";
		historicTaskInstanceQuery.processInstanceId(processInstanceId);

		historicTaskInstanceQuery.includeTaskLocalVariables();

		List<HistoricTaskInstance> list = historicTaskInstanceQuery.list();

		for (HistoricTaskInstance historicTaskInstance : list) {
			System.out.println("===============");
			System.out.println("任务流程实例id:" + historicTaskInstance.getProcessInstanceId());
			System.out.println("任务id:" + historicTaskInstance.getId());
			System.out.println("任务标识:" + historicTaskInstance.getTaskDefinitionKey());
			System.out.println("任务负责人:" + historicTaskInstance.getAssignee());
			System.out.println("任务名称:" + historicTaskInstance.getName());
			System.out.println("任务开始时间:" + historicTaskInstance.getStartTime());
			System.out.println("任务结束时间:" + historicTaskInstance.getEndTime());
			OrderCustom orderCustom=(OrderCustom) historicTaskInstance.getTaskLocalVariables().get("order");
			if (orderCustom!=null) {
				System.out.println("price:"+orderCustom.getPrice());
			}
		}

	}
}
