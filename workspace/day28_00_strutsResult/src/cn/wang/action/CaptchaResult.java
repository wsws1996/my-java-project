package cn.wang.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import cn.dsna.util.images.ValidateCode;

import com.opensymphony.xwork2.ActionInvocation;

public class CaptchaResult extends StrutsResultSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3061181802689567297L;

	private int width = 120;
	private int height = 80;
	private int numCount = 4;
	private int lineNum = 100;

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setNumCount(int numCount) {
		this.numCount = numCount;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		ValidateCode validateCode = new ValidateCode(width, height, numCount, lineNum);
		BufferedImage image = validateCode.getBuffImg();
		HttpServletResponse response = ServletActionContext.getResponse();
		ImageIO.write(image, "jpeg", response.getOutputStream());
	}
}
