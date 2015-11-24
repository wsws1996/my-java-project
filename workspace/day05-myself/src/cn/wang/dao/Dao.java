package cn.wang.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Dao {
	public void run() throws IOException {
		URL url = Dao.class.getClassLoader().getResource("db.properties");
		String path = url.getPath();
		System.out.println(path);
		FileInputStream inputStream = new FileInputStream(path);
		FileOutputStream outputStream = new FileOutputStream(path);
		Properties properties=new Properties();
		properties.load(inputStream);
		System.out.println(properties.size());
		System.out.println(properties.getProperty("url"));
		//properties.setProperty("name", "ws");
		properties.store(outputStream, "");
	}
}
