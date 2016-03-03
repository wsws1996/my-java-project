package cn.wang.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.wang.dao.DepartmentDao;
import cn.wang.domain.Department;
import cn.wang.domain.Employee;
import cn.wang.utils.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.DepartmentDao#add(cn.wang.domain.Department)
	 */
	@Override
	public void add(Department department) throws SQLException {

		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "insert into department (id,name) values(?,?)";
		Object params[] = { department.getId(), department.getName() };
		queryRunner.update(sql, params);
		sql = "insert into employee(id,name,salary,department_id) values(?,?,?,?)";
		Set<Employee> set = department.getEmployees();

		Object params2[][] = new Object[set.size()][];

		int index = 0;

		for (Employee employee : set) {
			params2[index] = new Object[] { employee.getId(),
					employee.getName(), employee.getSalary(),
					department.getId() };
			index++;
		}
		queryRunner.batch(sql, params2);
	}

	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.DepartmentDao#find(java.lang.String)
	 */
	@Override
	public Department find(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from department where id=?";

		Department department = queryRunner.query(sql,
				new BeanHandler<Department>(Department.class), id);

		sql = "select id,name,salary from employee where department_id=?";
		List<Employee> list = queryRunner.query(sql,
				new BeanListHandler<Employee>(Employee.class), id);

		department.getEmployees().addAll(list);
		return department;
	}
}
