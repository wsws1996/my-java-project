package com.shopping.ftp;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPClientTest {
	@Test
	public void testFtp() throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.33.10", 21);

		ftpClient.login("ftpuser", "ftpuser");

		FileInputStream fileInputStream = new FileInputStream(new File("/home/wang/图片/壁纸/6630236534908275842.jpg"));

		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");

		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

		ftpClient.storeFile("hello.jpg", fileInputStream);

		ftpClient.logout();

	}
}
