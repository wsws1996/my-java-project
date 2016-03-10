package org.wang.crm.service.impl;

import org.wang.crm.dao.DepartmentDao;
import org.wang.crm.dao.base.CommonDao;
import org.wang.crm.domain.Department;
import org.wang.crm.service.DepartmentService;
import org.wang.crm.service.base.impl.CommonServiceImpl;

public class DepartmentServiceImpl extends CommonServiceImpl<Department>
		implements DepartmentService {
	private DepartmentDao departmentDao;

	@Override
	public CommonDao<Department> getCommonDao() {
		return departmentDao;
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	public void deleteByOrder() {
		this.departmentDao.deleteByOrder();
	}
	
}
