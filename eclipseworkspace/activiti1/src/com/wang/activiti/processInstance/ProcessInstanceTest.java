package com.wang.activiti.processInstance;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.junit.Test;

public class ProcessInstanceTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deployProgress() {
		RepositoryService repositoryService = processEngine.getRepositoryService();

		String resourceName_bpmn = "purchasingflow01.bpmn";

		InputStream inputStream_bpmn = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/purchasingflow01.bpmn");

		String resourceName_png = "purchasingflow01.png";

		InputStream inputStream_png = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/purchasingflow01.png");

		Deployment deployment = repositoryService.createDeployment().addInputStream(resourceName_bpmn, inputStream_bpmn)
				.addInputStream(resourceName_png, inputStream_png).deploy();

		System.out.println("部署id:" + deployment.getId());
		System.out.println("部署时间:" + deployment.getDeploymentTime());
	}

	@Test
	public void startProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();

		String processDefinitionKey = "purchasingflow";

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
		System.out.println("流程实例所属流程定义id:" + processInstance.getProcessDefinitionId());
		System.out.println("流程实例的id:" + processInstance.getProcessInstanceId());
		System.out.println("流程实例的执行id:" + processInstance.getId());
		System.out.println("流程当前的活动id:" + processInstance.getActivityId());
		System.out.println("业务标识:" + processInstance.getBusinessKey());
	}

	@Test
	public void startProcessInstanceSetBussinessKey() {
		RuntimeService runtimeService = processEngine.getRuntimeService();

		String processDefinitionKey = "purchasingflow";

		String businessKey = "001";

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
		System.out.println("流程实例所属流程定义id:" + processInstance.getProcessDefinitionId());
		System.out.println("流程实例的id:" + processInstance.getProcessInstanceId());
		System.out.println("流程实例的执行id:" + processInstance.getId());
		System.out.println("流程当前的活动id:" + processInstance.getActivityId());
		System.out.println("业务标识:" + processInstance.getBusinessKey());
	}

	@Test
	public void queryProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();

		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();

		String processDefinitionKey = "purchasingflow";

		processInstanceQuery.processDefinitionKey(processDefinitionKey);
		List<ProcessInstance> list = processInstanceQuery.list();

		for (ProcessInstance processInstance : list) {
			System.out.println("================================");
			System.out.println("流程实例所属流程定义id:" + processInstance.getProcessDefinitionId());
			System.out.println("流程实例的id:" + processInstance.getProcessInstanceId());
			System.out.println("流程实例的执行id:" + processInstance.getId());
			System.out.println("流程当前的活动id:" + processInstance.getActivityId());
			System.out.println("业务标识:" + processInstance.getBusinessKey());
		}
	}

	@Test
	public void activeAndSuspendProcessDefinition() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ProcessDefinition processDefinition = repositoryService.getProcessDefinition("purchasingflow:4:1504");
		if (processDefinition.isSuspended()) {
			System.out.println("流程定义被暂停，即将激活");
			repositoryService.activateProcessDefinitionById("purchasingflow:4:1504");
		} else {
			System.out.println("流程定义被激活，即将暂停");
			repositoryService.suspendProcessDefinitionById("purchasingflow:4:1504");
		}
	}

	@Test
	public void activeAndSuspendProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId("1701")
				.singleResult();
		if (processInstance.isSuspended()) {
			System.out.println("流程实例被暂停，即将激活");
			runtimeService.activateProcessInstanceById("1701");
		} else {
			System.out.println("流程实例被激活，即将暂停");
			runtimeService.suspendProcessInstanceById("1701");
		}
	}
}
