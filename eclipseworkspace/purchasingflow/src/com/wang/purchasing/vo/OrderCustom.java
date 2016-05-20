package com.wang.purchasing.vo;

import com.wang.purchasing.po.PurBusOrder;

public class OrderCustom extends PurBusOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 535568306227852915L;

	private String taskId;

	private String taskName;

	private String taskDefinitionKey;

	private String assignee;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDefinitionKey() {
		return taskDefinitionKey;
	}

	public void setTaskDefinitionKey(String taskDefinitionKey) {
		this.taskDefinitionKey = taskDefinitionKey;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

}
