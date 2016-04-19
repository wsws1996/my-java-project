package junit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.wang.elec.domain.ElecSystemDDL;

public class TestCache {
	@Test
	public void save() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		ElecSystemDDL ddl = (ElecSystemDDL) session.get(ElecSystemDDL.class, 1);
		ElecSystemDDL ddl2 = (ElecSystemDDL) session
				.get(ElecSystemDDL.class, 1);

		transaction.commit();
		session.close();

		session = factory.openSession();
		 transaction = session.beginTransaction();

		ElecSystemDDL ddl3 = (ElecSystemDDL) session.get(ElecSystemDDL.class, 1);
		ElecSystemDDL ddl4 = (ElecSystemDDL) session
				.get(ElecSystemDDL.class, 1);

		transaction.commit();
		session.close();

	}
}
