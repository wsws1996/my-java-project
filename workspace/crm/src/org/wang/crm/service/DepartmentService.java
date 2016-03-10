package org.wang.crm.service;

import org.wang.crm.domain.Department;
import org.wang.crm.service.base.CommonService;

public interface DepartmentService extends CommonService<Department>{
	public void deleteByOrder();
}
