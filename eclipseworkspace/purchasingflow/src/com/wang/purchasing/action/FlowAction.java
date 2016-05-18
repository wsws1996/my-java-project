package com.wang.purchasing.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.log4j.lf5.util.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wang.purchasing.util.ResourcesUtil;

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
		String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow",
				"purchasingProcessDefinitionKey");
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		processDefinitionQuery.processDefinitionKey(processDefinitionKey);

		List<ProcessDefinition> list = processDefinitionQuery.list();

		model.addAttribute("list", list);
		return "flow/queryProcessDefinition";
	}

	@RequestMapping("/deleteProcessDefinition")
	public String deleteProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		String deploymentId = processDefinition.getDeploymentId();
		repositoryService.deleteDeployment(deploymentId, true);
		return "redirect:queryProcessDefinition.action";
	}

	@RequestMapping("/queryProcessDefinitionResource")
	public void queryProcessDefinitionResource(HttpServletResponse response, String processDefinitionId, String resourceType) throws IOException {

		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();

		String deploymentId = processDefinition.getDeploymentId();

		String resourceName = null;
		if (resourceType.equals("bpmn")) {
			resourceName = processDefinition.getResourceName();

		} else if (resourceType.equals("png")) {
			resourceName = processDefinition.getDiagramResourceName();
		}

		InputStream inputStream = repositoryService.getResourceAsStream(deploymentId, resourceName);

//		StreamUtils.copy(inputStream, response.getOutputStream());//该方法来自apache的log4j日志包,源码如下
		//--------------------------------------------------------------------------------------------------
//		/**
//		   * Copies information from the input stream to the output stream using
//		   * a default buffer size of 2048 bytes.
//		   * @throws java.io.IOException
//		   */
//		  public static void copy(InputStream input, OutputStream output)
//		      throws IOException {
//		    copy(input, output, DEFAULT_BUFFER_SIZE);
//		  }
//
//		  /**
//		   * Copies information from the input stream to the output stream using
//		   * the specified buffer size
//		   * @throws java.io.IOException
//		   */
//		  public static void copy(InputStream input,
//		      OutputStream output,
//		      int bufferSize)
//		      throws IOException {
//		    byte[] buf = new byte[bufferSize];
//		    int bytesRead = input.read(buf);
//		    while (bytesRead != -1) {
//		      output.write(buf, 0, bytesRead);
//		      bytesRead = input.read(buf);
//		    }
//		    output.flush();
//		  }
		//---------------------------------------------------------------------
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = inputStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}
}
