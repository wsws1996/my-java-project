package org.wang.elec.dao.impl;


import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecUserFileDao;
import org.wang.elec.domain.ElecUserFile;

@Repository(IElecUserFileDao.SERVICE_NAME)
public class ElecUserFileDaoImpl extends CommonDaoImpl<ElecUserFile>
		implements IElecUserFileDao {
}
