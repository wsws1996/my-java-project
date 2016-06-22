package com.wang.activiti.db;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class CreateDb {
	public static void main(String[] args) {
		String resource = "activiti.cfg.xml";
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource(resource);

		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println(processEngine);
	}
}
