package cn.wang.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.wang.dao.PersonDao;
import cn.wang.domain.Person;
import cn.wang.utils.JdbcUtil;

public class PersonDaoImpl implements PersonDao {
	/* (non-Javadoc)
	 * @see cn.wang.dao.impl.PersonDao#add(cn.wang.domain.Person)
	 */
	@Override
	public void add(Person person) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

		String sql = "insert into person(id,name) values(?,?)";
		Object params[] = { person.getId(), person.getName() };
		queryRunner.update(sql, params);
		sql = "insert into idcard(id,address) values(?,?)";
		params = new Object[] { person.getIdcard().getId(),
				person.getIdcard().getAddress() };
		queryRunner.update(sql, params);

	}
}
