package org.wang.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecText;
import org.wang.elec.service.IElecTextService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("elecTextAction")
@Scope(value = "prototype")
public class ElecTextAction extends BaseAction<ElecText> {

	ElecText elecText = this.getModel();

	@Resource(name = IElecTextService.SERVICE_NAME)
	IElecTextService elecTextService;

	public String save() {
		elecTextService.saveElecText(elecText);
		return "save";
	}

}
