package com.wang.purchasing.action;

import java.io.InputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/flow")
public class FlowAction {

	@Autowired
	private RepositoryService repositoryService;

	@RequestMapping("/deployProcess")
	public String deployProcess(Model model) throws Exception {
		return "flow/deployProcess";
	}

	@RequestMapping("/deployProcessSubmit")
	public String deployProcessSubmit(MultipartFile resource_bpmn, MultipartFile resource_png) throws Exception {

		String resourceName_bpmn = resource_bpmn.getOriginalFilename();

		InputStream inputStream_bpmn = resource_bpmn.getInputStream();

		String resourceName_png = resource_png.getOriginalFilename();

		InputStream inputStream_png = resource_png.getInputStream();

		Deployment deployment = repositoryService.createDeployment().addInputStream(resourceName_bpmn, inputStream_bpmn)
				.addInputStream(resourceName_png, inputStream_png).deploy();
		System.out.println("部署id:" + deployment.getId());
		System.out.println("部署时间:" + deployment.getDeploymentTime());

		return "redirect:queryProcessDefinition.action";
	}

	@RequestMapping("queryProcessDefinition")
	public String queryProcessDefinition(Model model) {
		return "flow/queryProcessDefinition";
	}
}
