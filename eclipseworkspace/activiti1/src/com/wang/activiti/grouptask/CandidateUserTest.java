package com.wang.activiti.grouptask;

import java.io.InputStream;
import java.util.List;

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

public class CandidateUserTest {
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	@Test
	public void deployProgress() {
		RepositoryService repositoryService = processEngine.getRepositoryService();

		String resourceName_bpmn = "purchasingflow04.bpmn";

		InputStream inputStream_bpmn = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/purchasingflow04.bpmn");

		String resourceName_png = "purchasingflow04.png";

		InputStream inputStream_png = this.getClass().getClassLoader()
				.getResourceAsStream("diagram/purchasingflow04.png");

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
		System.out.println("流程实例的id:" + processInstance.getProcessInstanceId());
	}

	@Test
	public void queryGroupTaskListByCandidateUser() {
		TaskService taskService = processEngine.getTaskService();
		TaskQuery taskQuery = taskService.createTaskQuery();
		String candidateUser = "zhangsan3";
		taskQuery.taskCandidateUser(candidateUser);

		String processDefinitionKey = "purchasingflow";
		taskQuery.processDefinitionKey(processDefinitionKey);
		List<Task> list = taskQuery.list();

		for (Task task : list) {
			System.out.println("任务流程实例id:" + task.getProcessInstanceId());
			System.out.println("任务id:" + task.getId());
			System.out.println("任务标识:" + task.getTaskDefinitionKey());
			System.out.println("任务负责人:" + task.getAssignee());
			System.out.println("任务名称:" + task.getName());
			System.out.println("任务创建时间:" + task.getCreateTime());
		}
	}

	@Test
	public void claimTask() {
		TaskService taskService = processEngine.getTaskService();

		String taskId = "7004";

		String candidateUser = "zhangsan3";

		Task task = taskService.createTaskQuery().taskId(taskId).taskCandidateUser(candidateUser).singleResult();

		if (task != null) {
			taskService.claim(taskId, candidateUser);
			System.out.println("拾取任务成功");
		}
	}

	@Test
	public void setAssignee() {
		TaskService taskService = processEngine.getTaskService();

		String taskId = "7004";
		String assignee = "zhangsan3";

		Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(assignee).singleResult();
		if (task != null) {
			taskService.setAssignee(taskId, null);
			System.out.println("任务归还成功");
		}
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
		String taskId = "6704";
		String assignee = "zhangsan3";
		Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(assignee).singleResult();

		if (task != null) {
			taskService.complete(taskId);
			System.out.println("完成任务:" + taskId);
		}
	}
}
