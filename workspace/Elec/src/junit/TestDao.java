package junit;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wang.elec.dao.IElecTextDao;
import org.wang.elec.domain.ElecText;

public class TestDao {
	@Test
	public void save() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao) ac
				.getBean(IElecTextDao.SERVICE_NAME);
		ElecText elecText = new ElecText();
		elecText.setTextName("测试Dao名称");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("测试Dao备注");
		elecTextDao.save(elecText);
	}
}
