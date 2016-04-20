package org.wang.elec.dao.impl;

import org.springframework.stereotype.Repository;
import org.wang.elec.dao.IElecExportFieldsDao;
import org.wang.elec.domain.ElecExportFields;

@Repository(IElecExportFieldsDao.SERVICE_NAME)
public class ElecExportFieldsDaoImpl extends CommonDaoImpl<ElecExportFields>
		implements IElecExportFieldsDao {

}
