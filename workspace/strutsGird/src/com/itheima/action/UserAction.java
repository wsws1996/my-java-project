package com.itheima.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.util.Genertor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1979424279728718075L;

	private User user = new User();

	private List<User> users = new ArrayList<User>();
	private String isUpload;
	private String[] interests;
	private File upload;
	private String uploadFileName;
	
	private InputStream inputStream;
	
	private BusinessService businessService;

	public String login() {
		User logonUser = businessService.login(user.getLogonName(),
				user.getLogonPwd());
		if (logonUser == null) {
			addActionError("错误的用户名或密码");
			return LOGIN;
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("user", logonUser);
		return SUCCESS;
	}

	public String list() {
		users = businessService.findAllUsers();
		return SUCCESS;
	}

	public String search() {
		users = businessService.findUsersByCondition(user.getUserName(),
				user.getSex(), user.getEducation(), isUpload);
		return SUCCESS;
	}

	public String add() throws IOException {
		if (interests != null && interests.length > 0) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < interests.length; i++) {
				if (i > 0) {
					stringBuffer.append(",");
				}
				stringBuffer.append(interests[i]);
			}
			user.setInterest(stringBuffer.toString());
			String storeDirectory = ServletActionContext.getServletContext()
					.getRealPath("/files");
			String uuidFlieName = UUID.randomUUID().toString() + "_"
					+ uploadFileName;
			user.setFilename(uuidFlieName);
			String path = Genertor.genChildDir(storeDirectory, uuidFlieName);
			user.setPath(path);
			FileUtils.copyFile(upload, new File(storeDirectory + File.separator
					+ path, uuidFlieName));
			businessService.addUser(user);
		}
		return SUCCESS;
	}

	public String del() {
		businessService.delUser(user);
		return SUCCESS;
	}

	public String view() {
		user = businessService.findUserById(user.getUserID());
		return SUCCESS;
	}
	public String download() throws FileNotFoundException {
		user=businessService.findUserById(user.getUserID());
		String storeDirectory=ServletActionContext.getServletContext().getRealPath("files");
		inputStream=new FileInputStream(storeDirectory+File.separator+user.getPath()+File.separator+user.getFilename());
		return SUCCESS;
	}
	public String editUI() {
		user = businessService.findUserById(user.getUserID());
		ValueStack valueStack=ServletActionContext.getContext().getValueStack();
		valueStack.push(user);
		return SUCCESS;
	}
	
	public String edit() throws IOException {
		User dbUser=businessService.findUserById(user.getUserID());
		if (interests != null && interests.length > 0) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < interests.length; i++) {
				if (i > 0) {
					stringBuffer.append(",");
				}
				stringBuffer.append(interests[i]);
			}
			user.setInterest(stringBuffer.toString());
			if (uploadFileName==null) {
				user.setPath(dbUser.getPath());
				user.setFilename(dbUser.getFilename());
			}else {
			String storeDirectory = ServletActionContext.getServletContext()
					.getRealPath("/files");
			String uuidFlieName = UUID.randomUUID().toString() + "_"
					+ uploadFileName;
			user.setFilename(uuidFlieName);
			String path = Genertor.genChildDir(storeDirectory, uuidFlieName);
			user.setPath(path);
			FileUtils.copyFile(upload, new File(storeDirectory + File.separator
					+ path, uuidFlieName));
			}
			businessService.editUser(user);
		}
		return SUCCESS;
	}
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}

	public String[] getInterests() {
		return interests;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
