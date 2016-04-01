package org.wang.elec.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

public class FileUtils {

	/**
	 * 完成文件上传的同时，返回路径path
	 * 
	 * @param file
	 *            :上传的文件
	 * @param fileName
	 *            :上传的文件名
	 * @param model
	 *            :模块名称
	 * @return:文件路径
	 */
	public static String fileUploadReturnPath(File file, String fileName,
			String model) {
		String basepath = ServletActionContext.getServletContext().getRealPath(
				File.separator + "upload");
		String datepath = DateUtils.dateToStringByFile(new Date());
		String filepath = basepath + datepath + model;
		File dateFile = new File(filepath);
		if (!dateFile.exists()) {
			dateFile.mkdirs();
		}
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		String uuidFileName = UUID.randomUUID().toString() + prefix;
		File destFile = new File(filepath + File.separator + uuidFileName);
		file.renameTo(destFile);
		return File.separator + "upload" + datepath + model
				+ File.separator + uuidFileName;
	}

}
