package org.wang.elec.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecCommonMsgContentDao;
import org.wang.elec.domain.ElecCommonMsgContent;

@Repository(IElecCommonMsgContentDao.SERVICE_NAME)
public class ElecCommonMsgContentDaoImpl extends CommonDaoImpl<ElecCommonMsgContent> implements
		IElecCommonMsgContentDao {

}
