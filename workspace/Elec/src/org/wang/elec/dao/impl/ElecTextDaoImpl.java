package org.wang.elec.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecTextDao;
import org.wang.elec.domain.ElecText;

@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextDaoImpl extends CommonDaoImpl<ElecText> implements
		IElecTextDao {

}
