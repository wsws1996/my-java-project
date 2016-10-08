package com.wang.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.wang.common.web.ResponseUtils;
import com.wang.core.web.Constants;

/**
 * 上传图片 商品 品牌 商品介绍Fck
 * 
 * @author wang
 *
 */
@Controller
public class UploadController {

	// 上传图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {
		// 扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());

		// 图片名称生成策略
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		String format = df.format(new Date());

		// 随机三位数
		Random r = new Random();

		for (int i = 0; i < 3; i++) {
			format += r.nextInt(10);
		}

		// 实例化一个Jersey
		Client client = new Client();

		// 保存数据库
		String path = "upload/" + format + "." + ext;

		// 另一台服务器的请求路径
		String url = Constants.IMAGE_URL + path;
		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始 POST GET PUT
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

		ResponseUtils.renderJson(response, jo.toString());
		
	}
}
