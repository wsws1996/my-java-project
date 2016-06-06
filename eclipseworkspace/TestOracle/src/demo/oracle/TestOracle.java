package demo.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;

import demo.util.JDBCUtils;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class TestOracle {
	@Test
	public void testProcedure() {
		String sql = "{call queryEmpInfo(?,?,?,?)}";
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			callableStatement = connection.prepareCall(sql);

			callableStatement.setInt(1, 7839);

			callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);
			callableStatement.registerOutParameter(3, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(4, OracleTypes.VARCHAR);

			callableStatement.execute();

			String name = callableStatement.getString(2);
			double sal = callableStatement.getDouble(3);
			String job = callableStatement.getString(4);
			System.out.println(name + "\t" + sal + "\t" + job);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection, callableStatement, null);
		}
	}

	@Test
	public void testFunction() {
		String sql = "{?=call queryEmpIncome(?)}";
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = JDBCUtils.getConnection();
			callableStatement = connection.prepareCall(sql);

			callableStatement.registerOutParameter(1, OracleTypes.NUMBER);

			callableStatement.setInt(2, 7839);

			callableStatement.execute();

			double income = callableStatement.getDouble(1);
			System.out.println(income);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection, callableStatement, null);
		}
	}

	@Test
	public void testCursor() {
		String sql = "{call MYPACKAGE.queryEmpList(?,?)}";
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			callableStatement = connection.prepareCall(sql);

			callableStatement.setInt(1, 20);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			callableStatement.execute();

			resultSet = ((OracleCallableStatement) callableStatement).getCursor(2);
			while (resultSet.next()) {
				String name = resultSet.getString("ename");
				double sal = resultSet.getDouble("sal");
				System.out.println(name + "\t" + sal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection, callableStatement, resultSet);
		}
	}
}
