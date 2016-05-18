package com.wang.activiti.task;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6582071822995830570L;

	@Override
	public void notify(DelegateTask delegateTask) {
		String assignee = "zhangsanfeng1";
		delegateTask.setAssignee(assignee);
	}

}
