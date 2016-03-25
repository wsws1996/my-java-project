package junit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Test
	public void update() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao) ac
				.getBean(IElecTextDao.SERVICE_NAME);
		ElecText elecText = new ElecText();
		elecText.setTextID("ff80808153a2b41b0153a2b41ed30001");
		elecText.setTextName("赵六u");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("赵六");
		elecTextDao.update(elecText);
	}

	@Test
	public void findObjectById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao) ac
				.getBean(IElecTextDao.SERVICE_NAME);
		Serializable id = "ff80808153a2b41b0153a2b41ed30001";

		ElecText elecText = elecTextDao.findObjectByID(id);

		System.out.println(elecText.getTextName() + "    "
				+ elecText.getTextRemark());
	}

	@Test
	public void deleteObjectByIds() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao) ac
				.getBean(IElecTextDao.SERVICE_NAME);
		Serializable id = "ff80808153a2c55b0153a2c55ed50001";
		elecTextDao.deleteObjectByIds(id);
	}
	@Test
	public void deleteObjectByCollection() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextDao elecTextDao = (IElecTextDao) ac
				.getBean(IElecTextDao.SERVICE_NAME);
		List<ElecText> list=new ArrayList<ElecText>(); 
		ElecText elecText1=new ElecText();
		elecText1.setTextID("ff80808153a2c9a90153a2c9ad7e0001");
		
		ElecText elecText2=new ElecText();
		elecText2.setTextID("ff80808153a2caaa0153a2cb7a560001");
		
		ElecText elecText3=new ElecText();
		elecText3.setTextID("ff80808153a2ce970153a2ce9ab70001");
		
		list.add(elecText1);
		list.add(elecText2);
		list.add(elecText3);
		
		elecTextDao.deleteObjectByCollection(list);
	}
}
