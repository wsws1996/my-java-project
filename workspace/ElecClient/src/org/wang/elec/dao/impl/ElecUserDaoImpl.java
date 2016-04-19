package org.wang.elec.dao.impl;


import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecUserDao;
import org.wang.elec.domain.ElecUser;

@Repository(IElecUserDao.SERVICE_NAME)
public class ElecUserDaoImpl extends CommonDaoImpl<ElecUser>
		implements IElecUserDao {
}
