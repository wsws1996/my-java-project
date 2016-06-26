package org.wang.elec.dao.impl;


import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecRoleDao;
import org.wang.elec.domain.ElecRole;

@Repository(IElecRoleDao.SERVICE_NAME)
public class ElecRoleDaoImpl extends CommonDaoImpl<ElecRole>
		implements IElecRoleDao {
	

}
