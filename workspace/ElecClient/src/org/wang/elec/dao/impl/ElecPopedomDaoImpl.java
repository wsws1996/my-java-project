package org.wang.elec.dao.impl;


import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecPopedomDao;
import org.wang.elec.domain.ElecPopedom;

@Repository(IElecPopedomDao.SERVICE_NAME)
public class ElecPopedomDaoImpl extends CommonDaoImpl<ElecPopedom>
		implements IElecPopedomDao {
	

}
