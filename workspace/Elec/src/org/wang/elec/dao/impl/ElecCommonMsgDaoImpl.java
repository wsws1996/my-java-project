package org.wang.elec.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecCommonMsgDao;
import org.wang.elec.domain.ElecCommonMsg;

@Repository(IElecCommonMsgDao.SERVICE_NAME)
public class ElecCommonMsgDaoImpl extends CommonDaoImpl<ElecCommonMsg> implements
		IElecCommonMsgDao {

}
