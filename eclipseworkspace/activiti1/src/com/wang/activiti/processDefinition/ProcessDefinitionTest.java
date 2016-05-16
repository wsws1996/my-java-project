package com.wang.activiti.processDefinition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ProcessDefinitionTest {
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
	public void queryProcessDefinition() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		String processDefinitionKey = "purchasingflow";
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		processDefinitionQuery.processDefinitionKey(processDefinitionKey);

		List<ProcessDefinition> list = processDefinitionQuery.list();

		for (ProcessDefinition processDefinition : list) {
			System.out.println("========================");
			System.out.println("流程定义id:" + processDefinition.getId());
			System.out.println("流程定义部署id:" + processDefinition.getDeploymentId());
			System.out.println("流程定义的key:" + processDefinition.getKey());
			System.out.println("流程定义的名称:" + processDefinition.getName());
			System.out.println("bpmn资源名称:" + processDefinition.getResourceName());
			System.out.println("png资源名称:" + processDefinition.getDiagramResourceName());
		}
	}

	@Test
	public void deleteProcessDefinition() {
		RepositoryService repositoryService = processEngine.getRepositoryService();
		String processDefinitionId = "purchasingflow:3:904";
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		String deploymentId = processDefinition.getDeploymentId();
		repositoryService.deleteDeployment(deploymentId, true);
	}

	@Test
	public void queryProcessDefinitionResource() throws IOException {
		RepositoryService repositoryService = processEngine.getRepositoryService();

		String processDefinitionId = "purchasingflow:2:304";

		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();

		String deploymentId = processDefinition.getDeploymentId();

		String resourceName_bpmn = processDefinition.getResourceName();

		InputStream inputStream_bpmn = repositoryService.getResourceAsStream(deploymentId, resourceName_bpmn);

		String resourceName_png = processDefinition.getDiagramResourceName();

		InputStream inputStream_png = repositoryService.getResourceAsStream(deploymentId, resourceName_png);

		File file_bpmn = new File("/home/wang/桌面/" + resourceName_bpmn);

		FileOutputStream fileOutputStream_bpmn = new FileOutputStream(file_bpmn);

		File file_png = new File("/home/wang/桌面/" + resourceName_png);
		// 文件复制用apache的common-io包!!!
		// FileUtils.copyInputStreamToFile(arg0, arg1);

		FileOutputStream fileOutputStream_png = new FileOutputStream(file_png);

		byte[] b = new byte[1024];
		int len = -1;
		while ((len = inputStream_bpmn.read(b, 0, 1024)) != -1) {
			fileOutputStream_bpmn.write(b, 0, len);
		}

		while ((len = inputStream_png.read(b, 0, 1024)) != -1) {
			fileOutputStream_png.write(b, 0, len);
		}

		inputStream_bpmn.close();
		inputStream_png.close();

		fileOutputStream_bpmn.close();
		fileOutputStream_png.close();

	}

}
