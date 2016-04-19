package junit;

import org.junit.Test;
import org.wang.elec.domain.xsd.ElecSystemDDL;
import org.wang.elec.webservice.FindSystemByKeyword;
import org.wang.elec.webservice.FindSystemByKeywordResponse;
import org.wang.elec.webservice.IWebSystemDDLServiceSkeleton;

public class TestWebservice {
	@Test
	public void testWebservice() {
		IWebSystemDDLServiceSkeleton ddlServiceSkeleton=new IWebSystemDDLServiceSkeleton();
		FindSystemByKeyword findSystemByKeyword=new FindSystemByKeyword();
		findSystemByKeyword.setArgs0("所属单位");
		FindSystemByKeywordResponse byKeywordResponse=ddlServiceSkeleton.findSystemByKeyword(findSystemByKeyword);
		ElecSystemDDL [] ddls=byKeywordResponse.get_return();
		if (ddls!=null&&ddls.length>0) {
			for (ElecSystemDDL elecSystemDDL : ddls) {
				System.out.println(elecSystemDDL.getDdlCode()+":"+elecSystemDDL.getDdlName()+":"+elecSystemDDL.getKeyword());
			}
		}
	}

}
