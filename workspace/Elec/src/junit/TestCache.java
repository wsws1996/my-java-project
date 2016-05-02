package junit;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.wang.elec.domain.ElecSystemDDL;

public class TestCache {
	@Test
	public void testCache() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		@SuppressWarnings("unused")
		ElecSystemDDL ddl = (ElecSystemDDL) session.get(ElecSystemDDL.class, 1);
		@SuppressWarnings("unused")
		ElecSystemDDL ddl2 = (ElecSystemDDL) session
				.get(ElecSystemDDL.class, 1);

		transaction.commit();
		session.close();

		session = factory.openSession();
		 transaction = session.beginTransaction();

		@SuppressWarnings("unused")
		ElecSystemDDL ddl3 = (ElecSystemDDL) session.get(ElecSystemDDL.class, 1);
		@SuppressWarnings("unused")
		ElecSystemDDL ddl4 = (ElecSystemDDL) session
				.get(ElecSystemDDL.class, 1);

		transaction.commit();
		session.close();

	}
	@Test
	public void testQueryCache(){
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query=session.createQuery("from ElecSystemDDL o where o.keyword='性别'");
		query.setCacheable(true);
		query.list();
		
		transaction.commit();
		session.close();
		
		session=factory.openSession();
		transaction=session.beginTransaction();
		
		Query query1=session.createQuery("from ElecSystemDDL o where o.keyword='性别'");
		query1.setCacheable(true);
		query1.list();
				
		
		transaction.commit();
		session.close();
	}
}
