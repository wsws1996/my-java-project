package org.wang.elec.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wang.elec.domain.ElecFileUpload;
import org.wang.elec.domain.ElecSystemDDL;
import org.wang.elec.domain.ElecUserFile;
import org.wang.elec.service.IElecFileUploadService;
import org.wang.elec.service.IElecSystemDDLService;

@SuppressWarnings("serial")
@Controller("elecFileUploadAction")
@Scope(value = "prototype")
public class ElecFileUploadAction extends BaseAction<ElecFileUpload> {

	ElecFileUpload elecFileUpload = this.getModel();

	/**
	 * 注入资料图纸管理service
	 */
	@Resource(name = IElecFileUploadService.SERVICE_NAME)
	IElecFileUploadService elecFileUploadService;

	/**
	 * 注入数据字典的Service
	 */
	@Resource(name = IElecSystemDDLService.SERVICE_NAME)
	IElecSystemDDLService elecSystemDDLService;

	/**
	 * @name:home
	 * @description:资料图纸管理的首页显示
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-21
	 * @param: 无
	 * @return String 跳转到dataChart/dataChartIndex.jsp
	 */
	public String home() {
		this.initSystemDDL();
		return "home";
	}

	private void initSystemDDL() {
		List<ElecSystemDDL> jctList = elecSystemDDLService
				.findSystemDDLByKeyword("所属单位");
		request.setAttribute("jctList", jctList);
		List<ElecSystemDDL> picList = elecSystemDDLService
				.findSystemDDLByKeyword("图纸类别");
		request.setAttribute("picList", picList);
	}

	/**
	 * @name:add
	 * @description:跳转到新增页面的页面
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-21
	 * @param: 无
	 * @return String 跳转到dataChart/dataChartAdd.jsp
	 */
	public String add() {
		this.initSystemDDL();
		return "add";
	}

	/**
	 * @name:save
	 * @description:保存资料图纸管理（管理员进行文件上传操作）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-21
	 * @param: 无
	 * @return String 重定向dataChart/dataChartAdd.jsp
	 */
	public String save() {
		elecFileUploadService.saveFileUpload(elecFileUpload);
		return "save";
	}

	/**
	 * @name addList
	 * @description 使用所属单位和图纸类别查询对应的文件上传的数据信息
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-23
	 * @param 无
	 * @return String 跳转到dataChart/dataChartAddList.jsp
	 *         将dataChartAddList.jsp页面的内容，放置到dataChartAdd.jsp的Form2表单中
	 */
	public String addList() {
		List<ElecFileUpload> list = elecFileUploadService
				.findFileUploadListByCondition(elecFileUpload);
		request.setAttribute("list", list);
		return "addList";
	}

	/**
	 * @name:download
	 * @description:文件下载（struts2方式）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-23
	 * @param: 无
	 * @return struts2的结果类型
	 */
	public String download() {
		try {
			Integer fileID = elecFileUpload.getSeqId();
			ElecFileUpload fileUpload = elecFileUploadService
					.findFileByID(fileID);
			String path = ServletActionContext.getServletContext().getRealPath(
					"")
					+ fileUpload.getFileUrl();

			String filename = fileUpload.getFileName();
			filename = new String(filename.getBytes("UTF-8"), "iso8859-1");
			request.setAttribute("filename", filename);
			InputStream in = new FileInputStream(new File(path));
			elecFileUpload.setInputStream(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "download";
	}
	
	/**
	 * @name luceneHome
	 * @description 使用lucene进行全文检索
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-24
	 * @param 无
	 * @return String 跳转到dataChart/dataIndex.jsp
	 */
	public String luceneHome() {
		this.initSystemDDL();
		List<ElecFileUpload> list=elecFileUploadService.findFileUploadByLuceneCondition(elecFileUpload);
		request.setAttribute("list", list);
		return "luceneHome";
	}
	
	/**
	 * @name delete
	 * @description 删除资料图纸管理的数据
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-24
	 * @param 无
	 * @return String 重定向到dataChart/dataIndex.jsp
	 */
	public String delete() {
		Integer seqId=elecFileUpload.getSeqId();
		elecFileUploadService.deleteFileUploadByID(seqId);
		return "delete";
	}
}
