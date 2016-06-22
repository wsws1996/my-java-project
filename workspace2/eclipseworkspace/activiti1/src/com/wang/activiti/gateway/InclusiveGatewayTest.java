package com.wang.activiti.gateway;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class InclusiveGatewayTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deployProgress() {
		RepositoryService repositoryService = processEngine.getRepositoryService();

		String resourceName_bpmn = "inclusiveGateway.bpmn";

		InputStream inputStream_bpmn = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/inclusiveGateway.bpmn");

		String resourceName_png = "inclusiveGateway.png";

		InputStream inputStream_png = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/inclusiveGateway.png");

		Deployment deployment = repositoryService.createDeployment().addInputStream(resourceName_bpmn, inputStream_bpmn)
				.addInputStream(resourceName_png, inputStream_png).deploy();

		System.out.println("部署id:" + deployment.getId());
		System.out.println("部署时间:" + deployment.getDeploymentTime());
	}

	@Test
	public void startProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();

		String processDefinitionKey = "inclusiveGateway";
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("userType", "2");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
		System.out.println("流程实例的id:" + processInstance.getProcessInstanceId());
	}

	@Test
	public void findPersonalTaskList() {
		TaskService taskService = processEngine.getTaskService();

		String processDefinitionKey = "purchasingflow";

		String assignee = "zhangsan3";

		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.taskAssignee(assignee);

		taskQuery.processDefinitionKey(processDefinitionKey);

		List<Task> list = taskQuery.list();

		for (Task task : list) {
			System.out.println("任务流程实例id:" + task.getProcessInstanceId());
			System.out.println("任务id:" + task.getId());
			System.out.println("任务标识:" + task.getTaskDefinitionKey());
			System.out.println("任务负责人:" + task.getAssignee());
			System.out.println("任务名称:" + task.getName());
		}
	}

	@Test
	public void complateTask() {
		TaskService taskService = processEngine.getTaskService();
		String taskId = "12410";

		taskService.complete(taskId);
		System.out.println("完成任务:" + taskId);
	}
}
