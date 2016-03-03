package cn.wang.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload2Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -718049968643730294L;

	/**
	 * @return
	 */
	private String name;
	private File [] photo;
	private String [] photoFileName;
	private String photoContentType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File[] getPhoto() {
		return photo;
	}

	public void setPhoto(File[] photo) {
		this.photo = photo;
	}

	public String[] getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String execute() throws IOException {
		ServletContext context=ServletActionContext.getServletContext();
		String directory=context.getRealPath("/files");
		if (photo!=null&&photo.length>0) {
			for (int i = 0; i < photo.length; i++) {
				File target=new File(directory,photoFileName[i]);
				FileUtils.copyFile(photo[i], target);
			}
		}
		return SUCCESS;
	}
}