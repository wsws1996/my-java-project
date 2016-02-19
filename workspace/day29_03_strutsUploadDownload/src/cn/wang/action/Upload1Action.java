package cn.wang.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload1Action extends ActionSupport {

	/**
	 * 
	 */
	private String name;
	private File photo;
	private String photoFileName;
	private String photoContentType;

	public String upload() throws IOException {

		ServletContext context = ServletActionContext.getServletContext();
		String directory = context.getRealPath("/files");
		File target = new File(directory, photoFileName);

		FileUtils.copyFile(photo, target);
		System.out.println(name);
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	private static final long serialVersionUID = -8961129881419065179L;

}