package com.wang;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 发送图片到另一台Tomcat服务器的
 * @author wang
 *
 */
public class JersyDemo {
	public static void main(String[] args) throws IOException {
		//实例化一个Jersey
		Client client=new Client();
		
		//另一台服务器的请求路径
		String url="http://localhost:8088/image-web/upload/qqq.jpg";
		//设置请求路径
		WebResource resource= client.resource(url);
		
		String path="/home/wang/图片/壁纸.jpg";
		
		//将图片读到内存
		byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
		
		//发送开始 POST GET PUT
		resource.put(String.class, readFileToByteArray);
		
		System.out.println("发送完毕！");
	}
}
