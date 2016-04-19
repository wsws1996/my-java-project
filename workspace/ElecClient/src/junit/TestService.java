package junit;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

	@Test
	public void findCollectionByConditionNoPage() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextService iElecTextService = (IElecTextService) ac
				.getBean(IElecTextService.SERVICE_NAME);
		ElecText elecText = new ElecText();
//		elecText.setTextName("张");
//		elecText.setTextRemark("张");
		List<ElecText> list = iElecTextService
				.findCollectionByConditionNoPage(elecText);
		if (list != null && list.size() > 0) {
			for (ElecText text : list) {
				System.out.println(text.getTextName() + "       "
						+ text.getTextRemark());
			}
		}
	}
}
