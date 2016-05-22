package com.wang.activiti.variable;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class GlobalVariableTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deployProgress() {
		RepositoryService repositoryService = processEngine.getRepositoryService();

		String resourceName_bpmn = "purchasingflow02.bpmn";

		InputStream inputStream_bpmn = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/purchasingflow02.bpmn");

		String resourceName_png = "purchasingflow02.png";

		InputStream inputStream_png = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/purchasingflow02.png");

		Deployment deployment = repositoryService.createDeployment().addInputStream(resourceName_bpmn, inputStream_bpmn)
				.addInputStream(resourceName_png, inputStream_png).deploy();

		System.out.println("部署id:" + deployment.getId());
		System.out.println("部署时间:" + deployment.getDeploymentTime());
	}

	@Test
	public void startProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();

		String processDefinitionKey = "purchasingflow";

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("assignee", "张三");

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
		System.out.println("流程实例所属流程定义id:" + processInstance.getProcessDefinitionId());
		System.out.println("流程实例的id:" + processInstance.getProcessInstanceId());
		System.out.println("流程实例的执行id:" + processInstance.getId());
		System.out.println("流程当前的活动id:" + processInstance.getActivityId());
		System.out.println("业务标识:" + processInstance.getBusinessKey());
		System.out.println("流程变量:" + processInstance.getProcessVariables());
	}

	@Test
	public void complateTask() {
		TaskService taskService = processEngine.getTaskService();
		String taskId = "3702";
		String assignee = "wangwu";
		Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(assignee).singleResult();

		if (task != null) {
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("assignee", "李四");
//			taskService.complete(taskId, variables);
			taskService.complete("3702");
			System.out.println("完成任务:" + taskId);
		}
	}

	@Test
	public void setVariableByProcessInstanceId() {
		RuntimeService runtimeService = processEngine.getRuntimeService();
		runtimeService.setVariable("401", "price", 12344);
	}

	@Test
	public void setVariableByTaskId() {
		TaskService taskService=processEngine.getTaskService();
		
		taskService.setVariable("4102", "price", 24445);
		System.out.println(taskService.getVariable("4102", "price"));
	}
}
