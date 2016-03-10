package org.wang.crm.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.wang.crm.dao.DepartmentDao;
import org.wang.crm.dao.base.impl.CommonDaoImpl;
import org.wang.crm.domain.Department;

public class DepartmentDaoImpl extends CommonDaoImpl<Department> implements DepartmentDao {

	@Override
	public void deleteByOrder() {
		 this.getHibernateTemplate().execute(new HibernateCallback<Department>() {

			@Override
			public Department doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query= session.createQuery("select max(did) from Department");
				Serializable did= (Serializable) query.uniqueResult();
				Department department=(Department) session.get(Department.class, did);
				session.delete(department);
				return null;
			}
		});
	}

}
