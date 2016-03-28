package org.wang.elec.service.impl;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecCommonMsgContentDao;
import org.wang.elec.dao.IElecCommonMsgDao;
import org.wang.elec.domain.ElecCommonMsg;
import org.wang.elec.domain.ElecCommonMsgContent;
import org.wang.elec.service.IElecCommonMsgService;
import org.wang.elec.utils.StringUtil;

@Service(IElecCommonMsgService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecCommonMsgServiceImpl implements IElecCommonMsgService {

	/**
	 * 运行监控
	 */
	@Resource(name = IElecCommonMsgDao.SERVICE_NAME)
	IElecCommonMsgDao elecCommonMsgDao;
	
	@Resource(name=IElecCommonMsgContentDao.SERVICE_NAME)
	
	IElecCommonMsgContentDao elecCommonMsgContentDao;

//	/**
//	 * @name:findCommonMsg
//	 * @description:查询运行监控表的数据
//	 * @author wang
//	 * @version V1.0
//	 * @create Date: 2016-03-26
//	 * @param: 无
//	 * @return ElecCommonMsg 返回PO对象（运行监控的数据）
//	 */
//	
//	@Override
//	public ElecCommonMsg findCommonMsg() {
//		List<ElecCommonMsg> list=elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
//		ElecCommonMsg elecCommonMsg=null;
//		if(list!=null&&list.size()>0){
//			elecCommonMsg=list.get(0);
//		}
//		return elecCommonMsg;
//	}
//	
//	/**
//	 * @name:saveCommonMsg
//	 * @description:保存运行监控表的数据
//	 * @author wang
//	 * @version V1.0
//	 * @create Date: 2016-03-26
//	 * @param: elecCommonMsg 
//	 * @return 无
//	 */
//	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
//	@Override
//	public void saveCommonMsg(ElecCommonMsg elecCommonMsg) {
//		List<ElecCommonMsg> list=elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
//		/**
//		 * 数据存在，执行update
//		 */
//		if (list!=null&&list.size()>0) {
//			ElecCommonMsg commonMsg=list.get(0);
//			commonMsg.setDevRun(elecCommonMsg.getDevRun());
//			commonMsg.setStationRun(elecCommonMsg.getStationRun());
//			commonMsg.setCreateDate(new Date());
//			
//			//session中不允许存在具有相同OID的两个对象，否则抛出
////			org.hibernate.NonUniqueObjectException异常
//			//因此下面的更新方式不对
////			elecCommonMsg.setComID(commonMsg.getComID());
////			elecCommonMsg.setCreateDate(new Date());
////			elecCommonMsgDao.update(elecCommonMsg);
//		}
//		/**
//		 * 数据不存在，执行save
//		 */
//		else {
//			elecCommonMsg.setCreateDate(new Date());
//			elecCommonMsgDao.save(elecCommonMsg);
//		}
//	}
	
	public ElecCommonMsg findCommonMsg() {
		List<ElecCommonMsg> list = elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		ElecCommonMsg commonMsg = null;
		if(list!=null && list.size()>0){
			commonMsg = list.get(0);
			/**********************************************begin**********************************************************/
			//获取数据内容
			//以类型作为条件，按照显示顺序升序排列，查询站点运行情况的数据
			String stationCondition = " and o.type=?";
			Object [] stationParams = {"1"};
			Map<String, String> stationOrderby = new LinkedHashMap<String, String>();
			stationOrderby.put("o.orderby", "asc");
			List<ElecCommonMsgContent> stationList = elecCommonMsgContentDao.findCollectionByConditionNoPage(stationCondition, stationParams, stationOrderby);
			//获取返回的数据（拼装之后）
			String stationContent = "";
			if(stationList!=null && stationList.size()>0){
				for(ElecCommonMsgContent elecCommonMsgContent:stationList){
					String content = elecCommonMsgContent.getContent();
					stationContent += content;
				}
			}
			//将数据赋值给页面的属性（站点运行情况）
			commonMsg.setStationRun(stationContent);
			/**********************************************************************************/
			//以类型作为条件，按照显示顺序升序排列，查询站点运行情况的数据
			String devCondition = " and o.type=?";
			Object [] devParams = {"2"};
			Map<String, String> devOrderby = new LinkedHashMap<String, String>();
			devOrderby.put("o.orderby", "asc");
			List<ElecCommonMsgContent> devList = elecCommonMsgContentDao.findCollectionByConditionNoPage(devCondition, devParams, devOrderby);
			//获取返回的数据（拼装之后）
			String devContent = "";
			if(devList!=null && devList.size()>0){
				for(ElecCommonMsgContent elecCommonMsgContent:devList){
					String content = elecCommonMsgContent.getContent();
					devContent += content;
				}
			}
			//将数据赋值给页面的属性（设备运行情况）
			commonMsg.setDevRun(devContent);
			/**********************************************end**********************************************************/
		}
		return commonMsg;
	}
	
	/**  
	* @Name: saveElecCommonMsg
	* @Description: 保存运行监控
	* @Author: wang
	* @Version: V1.00 
	* @Create Date: 
	* @Parameters: ElecCommonMsg：封装保存的参数
	* @Return: 无
	*/
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveCommonMsg(ElecCommonMsg elecCommonMsg) {
		/**********************************************begin**********************************************************/
		//保存到数据表中
		//删除之前的数据
		List<ElecCommonMsgContent> contentList = elecCommonMsgContentDao.findCollectionByConditionNoPage("", null, null);
		elecCommonMsgContentDao.deleteObjectByCollection(contentList);
		//从页面获取站点运行情况和设备运行情况，根据站点运行情况，和设备运行情况保存数据
		String stationRun = elecCommonMsg.getStationRun();
		String devRun = elecCommonMsg.getDevRun();
		//调用StirngUtil的方法，分割字符串
		List<String> stationList = StringUtil.getContentByList(stationRun, 50);
		if(stationList!=null && stationList.size()>0){
			for(int i=0;i<stationList.size();i++){
				ElecCommonMsgContent elecCommonMsgContent = new ElecCommonMsgContent();
				elecCommonMsgContent.setType("1");//1表示站点运行情况
				elecCommonMsgContent.setContent(stationList.get(i));
				elecCommonMsgContent.setOrderby(i+1);
				elecCommonMsgContentDao.save(elecCommonMsgContent);
			}
		}
		List<String> devList = StringUtil.getContentByList(devRun, 50);
		if(devList!=null && devList.size()>0){
			for(int i=0;i<devList.size();i++){
				ElecCommonMsgContent elecCommonMsgContent = new ElecCommonMsgContent();
				elecCommonMsgContent.setType("2");//2表示设备运行情况
				elecCommonMsgContent.setContent(devList.get(i));
				elecCommonMsgContent.setOrderby(i+1);
				elecCommonMsgContentDao.save(elecCommonMsgContent);
			}
		}
		/**********************************************end**********************************************************/
		
		
		//查询运行监控表，获取运行监控表的数据，返回List<ElecCommonMsg> list，使用list作为判断数据库中是否存在数据
		List<ElecCommonMsg> list = elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		//如果list!=null:数据表表中存在数据，获取页面传递的2个参数，组织PO对象，执行更新（update）
		if(list!=null && list.size()>0){
			//方案一：先删除再创建
			//方案二：组织PO对象，执行update
			ElecCommonMsg commonMsg = list.get(0);
			commonMsg.setStationRun("1");//1表示站点运行情况
			commonMsg.setDevRun("2");//2表示设备运行情况
			commonMsg.setCreateDate(new Date());
		}
		//如果list==null:数据表表中不存在数据，获取页面传递的2个参数，组织PO对象，执行新增（save）
		else{
			ElecCommonMsg commonMsg = new ElecCommonMsg();
			commonMsg.setCreateDate(new Date());
			commonMsg.setStationRun("1");//1表示站点运行情况
			commonMsg.setDevRun("2");//2表示设备运行情况
			elecCommonMsgDao.save(commonMsg);
		}
		
		
	}
	
}
