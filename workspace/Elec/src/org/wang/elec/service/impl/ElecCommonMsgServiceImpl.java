package org.wang.elec.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecCommonMsgDao;
import org.wang.elec.domain.ElecCommonMsg;
import org.wang.elec.service.IElecCommonMsgService;

@Service(IElecCommonMsgService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecCommonMsgServiceImpl implements IElecCommonMsgService {

	@Resource(name = IElecCommonMsgDao.SERVICE_NAME)
	IElecCommonMsgDao elecCommonMsgDao;

	/**
	 * @name:findCommonMsg
	 * @description:查询运行监控表的数据
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: 无
	 * @return ElecCommonMsg 返回PO对象（运行监控的数据）
	 */
	
	@Override
	public ElecCommonMsg findCommonMsg() {
		List<ElecCommonMsg> list=elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		ElecCommonMsg elecCommonMsg=null;
		if(list!=null&&list.size()>0){
			elecCommonMsg=list.get(0);
		}
		return elecCommonMsg;
	}
	
	/**
	 * @name:saveCommonMsg
	 * @description:保存运行监控表的数据
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-03-26
	 * @param: elecCommonMsg 
	 * @return 无
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void saveCommonMsg(ElecCommonMsg elecCommonMsg) {
		List<ElecCommonMsg> list=elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		/**
		 * 数据存在，执行update
		 */
		if (list!=null&&list.size()>0) {
			ElecCommonMsg commonMsg=list.get(0);
			commonMsg.setDevRun(elecCommonMsg.getDevRun());
			commonMsg.setStationRun(elecCommonMsg.getStationRun());
			commonMsg.setCreateDate(new Date());
			
			//session中不允许存在具有相同OID的两个对象，否则抛出
//			org.hibernate.NonUniqueObjectException异常
			//因此下面的更新方式不对
//			elecCommonMsg.setComID(commonMsg.getComID());
//			elecCommonMsg.setCreateDate(new Date());
//			elecCommonMsgDao.update(elecCommonMsg);
		}
		/**
		 * 数据不存在，执行save
		 */
		else {
			elecCommonMsg.setCreateDate(new Date());
			elecCommonMsgDao.save(elecCommonMsg);
		}
	}
}
