package com.wang.purchasing.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.context.ApplicationContext;

import com.wang.purchasing.dao.mapper.PurBusOrderMapper;
import com.wang.purchasing.po.PurBusOrder;
import com.wang.purchasing.util.ApplicationContextUtils;

public class ProcessCompleteListener implements ExecutionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1689992327312767531L;
	private static ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();

	@Override
	public void notify(DelegateExecution execution) throws Exception {

		@SuppressWarnings("deprecation")
		String businesskey = execution.getBusinessKey();

		PurBusOrderMapper purBusOrderMapper = (PurBusOrderMapper) applicationContext.getBean("purBusOrderMapper");

		PurBusOrder purBusOrder_update = new PurBusOrder();
		purBusOrder_update.setId(businesskey);
		purBusOrder_update.setStatus("complete");

		purBusOrderMapper.updateByPrimaryKeySelective(purBusOrder_update);

	}

}
