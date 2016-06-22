package com.wang.purchasing.vo;

import java.io.Serializable;
import java.util.Date;

import com.wang.purchasing.po.PurBusOrder;

public class OrderCustom extends PurBusOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4586135244255969260L;

	private String taskId;

	private String taskName;

	private String taskDefinitionKey;

	private String assignee;

	private String activityId;

	private Date processInstance_startTime;

	private Date processInstance_endTime;

	private Date task_startTime;

	private Date task_endTime;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

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

	public Date getProcessInstance_startTime() {
		return processInstance_startTime;
	}

	public void setProcessInstance_startTime(Date processInstance_startTime) {
		this.processInstance_startTime = processInstance_startTime;
	}

	public Date getProcessInstance_endTime() {
		return processInstance_endTime;
	}

	public void setProcessInstance_endTime(Date processInstance_endTime) {
		this.processInstance_endTime = processInstance_endTime;
	}

	public Date getTask_startTime() {
		return task_startTime;
	}

	public void setTask_startTime(Date task_startTime) {
		this.task_startTime = task_startTime;
	}

	public Date getTask_endTime() {
		return task_endTime;
	}

	public void setTask_endTime(Date task_endTime) {
		this.task_endTime = task_endTime;
	}

}
