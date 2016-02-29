package cn.wang.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Download1Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2202422883094296742L;
	private InputStream inputStream;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException 
	 */
	public String execute() throws FileNotFoundException, UnsupportedEncodingException {
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"桌面.jpg");
		fileName=FilenameUtils.getName(realPath);
		inputStream = new FileInputStream(realPath);
		return SUCCESS;
	}
}