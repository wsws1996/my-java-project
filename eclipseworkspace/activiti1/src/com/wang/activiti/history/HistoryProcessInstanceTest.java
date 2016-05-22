package com.wang.activiti.history;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.junit.Test;

public class HistoryProcessInstanceTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void queryHistoryProcessInstance() {
		HistoryService historyService = processEngine.getHistoryService();
		
		String processDefinitionKey="purchasingflow";
		
		HistoricProcessInstanceQuery historicProcessInstanceQuery = historyService.createHistoricProcessInstanceQuery();
		historicProcessInstanceQuery.processDefinitionKey(processDefinitionKey);
		
		historicProcessInstanceQuery.finished();

		List<HistoricProcessInstance> list = historicProcessInstanceQuery.list();
		for (HistoricProcessInstance historicProcessInstance : list) {
			System.out.println("=====================");
			System.out.println("流程实例所属流程定义id:" + historicProcessInstance.getProcessDefinitionId());
			System.out.println("流程实例的id:" + historicProcessInstance.getId());
			System.out.println("业务标识:" + historicProcessInstance.getBusinessKey());
			System.out.println("开始执行时间:" + historicProcessInstance.getStartTime());
			System.out.println("结束执行时间:" + historicProcessInstance.getEndTime());
			System.out.println("执行时长:" + historicProcessInstance.getDurationInMillis());
		}

	}
}
