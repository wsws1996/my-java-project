package com.wang.purchasing.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wang.purchasing.dao.mapper.PurBusOrderAuditMapper;
import com.wang.purchasing.dao.mapper.PurBusOrderMapper;
import com.wang.purchasing.po.PurBusOrder;
import com.wang.purchasing.po.PurBusOrderAudit;
import com.wang.purchasing.po.PurBusOrderExample;
import com.wang.purchasing.service.OrderService;
import com.wang.purchasing.util.UUIDBuild;

public class OrderServiceImpl implements OrderService {
	@Autowired
	private PurBusOrderMapper purBusOrderMapper;

	@Autowired
	private PurBusOrderAuditMapper purBusOrderAuditMapper;

	// 创建采购单
	@Override
	public void saveOrder(String userId, PurBusOrder purBusOrder)
			throws Exception {
		// 采购单信息主键
		String order_id = UUIDBuild.getUUID();

		purBusOrder.setId(order_id);// 采购单id
		purBusOrder.setUserId(userId);// 创建用户id
		purBusOrder.setCreatetime(new Date());// 创建时间
		purBusOrder.setStatus("1");// 状态：初始状态为1未提交
		purBusOrderMapper.insert(purBusOrder);

	}

	// 根据id获取采购单信息
	@Override
	public PurBusOrder findOrderByid(String id) throws Exception {
		return purBusOrderMapper.selectByPrimaryKey(id);
	}

	// 查询创建采购单列表，只查询采购单状态为1未提交的记录
	public List<PurBusOrder> findCreateOrderList() throws Exception {
		// 定义查询条件
		PurBusOrderExample purBusOrderExample = new PurBusOrderExample();
		PurBusOrderExample.Criteria criteria = purBusOrderExample
				.createCriteria();
		// 指定采购单表状态为未提交
		criteria.andStatusEqualTo("1");

		return purBusOrderMapper.selectByExample(purBusOrderExample);
	}

	// 提交采购单，将采购单状态更新为部门经理审核中
	@Override
	public void saveSubmitOrder(String orderId) throws Exception {
		// 更新条件
		PurBusOrderExample purBusOrderExample = new PurBusOrderExample();
		PurBusOrderExample.Criteria criteria = purBusOrderExample
				.createCriteria();
		criteria.andIdEqualTo(orderId);// 只匹配该采购单id
		criteria.andStatusEqualTo("1");// 只更新未提交状态的采购单
		// 更新对象
		PurBusOrder purBusOrder = new PurBusOrder();
		purBusOrder.setStatus("2");// 部门经理审核中
		// 符合更新条件将采购单状态更新为2
		purBusOrderMapper.updateByExampleSelective(purBusOrder,
				purBusOrderExample);

	}
	//部门审核列表
	@Override
	public List<PurBusOrder> findFirstAuditList() throws Exception {
		// 定义查询条件
		PurBusOrderExample purBusOrderExample = new PurBusOrderExample();
		PurBusOrderExample.Criteria criteria = purBusOrderExample
				.createCriteria();
		// 指定采购单表状态为部门经理审核中
		criteria.andStatusEqualTo("2");

		return purBusOrderMapper.selectByExample(purBusOrderExample);

	}
    
	//部门经理审核提交
	@Override
	public void saveFirstAuditSubmit(String userId,String orderId,
			PurBusOrderAudit purBusOrderAudit) throws Exception {
		
		//保存审核信息
		purBusOrderAudit.setId(UUIDBuild.getUUID());
		purBusOrderAudit.setUserId(userId);
		purBusOrderAuditMapper.insert(purBusOrderAudit);
		
		//下边更新采购单表中的状态
		//更新条件
		PurBusOrderExample purBusOrderExample = new PurBusOrderExample();
		PurBusOrderExample.Criteria criteria = purBusOrderExample
				.createCriteria();
		criteria.andIdEqualTo(orderId);// 只匹配该采购单id
		criteria.andStatusEqualTo("2");// 只更新部门经理审核中的采购单
		
		//更新对象
		PurBusOrder purBusOrder = new PurBusOrder();
		//获取审核状态，根据审核状态确定采购单状态的值
		String status = purBusOrderAudit.getStatus();
		
		if(status!=null && status.equals("1")){
			purBusOrder.setStatus("4");// 总经理审核中
		}else{
			purBusOrder.setStatus("3");// 部门经理审核不通过
		}
		//更新采购单状态
		purBusOrderMapper.updateByExampleSelective(purBusOrder,
				purBusOrderExample);
	}
	//总经理审核中
	@Override
	public List<PurBusOrder> findSecondAuditList() throws Exception {
		// 定义查询条件
		PurBusOrderExample purBusOrderExample = new PurBusOrderExample();
		PurBusOrderExample.Criteria criteria = purBusOrderExample
				.createCriteria();
		// 指定采购单表状态为部门经理审核中
		criteria.andStatusEqualTo("4");

		return purBusOrderMapper.selectByExample(purBusOrderExample);

	}
	
	//总经理审核
	@Override
	public void saveSecondAuditSubmit(String userId, String orderId,
			PurBusOrderAudit purBusOrderAudit) throws Exception {
		
		//保存审核信息
		purBusOrderAudit.setId(UUIDBuild.getUUID());
		purBusOrderAudit.setUserId(userId);
		purBusOrderAuditMapper.insert(purBusOrderAudit);
		
		//下边更新采购单表中的状态
		//更新条件
		PurBusOrderExample purBusOrderExample = new PurBusOrderExample();
		PurBusOrderExample.Criteria criteria = purBusOrderExample
				.createCriteria();
		criteria.andIdEqualTo(orderId);// 只匹配该采购单id
		criteria.andStatusEqualTo("4");// 只更新总经理审核中的采购单
		
		//更新对象
		PurBusOrder purBusOrder = new PurBusOrder();
		//获取审核状态，根据审核状态确定采购单状态的值
		String status = purBusOrderAudit.getAuditType();
		
		if(status!=null && status.equals("1")){
			purBusOrder.setStatus("6");// 财务审核中
		}else{
			purBusOrder.setStatus("5");// 总经理审核不通过
		}
		//更新采购单状态
		purBusOrderMapper.updateByExampleSelective(purBusOrder,
				purBusOrderExample);
	}

	@Override
	public List<PurBusOrder> findThirdAuditList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveThirdAuditSubmit(String userId,String orderId,
			PurBusOrderAudit purBusOrderAudit) throws Exception {
		// TODO Auto-generated method stub

	}

}
