package junit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.wang.elec.domain.ElecText;

public class TestHibernate {
	@Test
	public void save() {
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		ElecText elecText=new ElecText();
		elecText.setTextName("测试hibernate名称");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("测试hibernate备注");
		
		session.save(elecText);
		
		transaction.commit();
		session.close();
	}
}
