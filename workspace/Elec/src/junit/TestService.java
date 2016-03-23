package junit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.elec.dao.IElecTextDao;
import org.wang.elec.domain.ElecText;
import org.wang.elec.service.IElecTextService;

public class TestService {
	@Test
	public void save() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextService iElecTextService = (IElecTextService) ac
				.getBean(IElecTextService.SERVICE_NAME);
		ElecText elecText = new ElecText();
		elecText.setTextName("测试Service名称");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("测试Service备注");
		iElecTextService.saveElecText(elecText);
	}
}
