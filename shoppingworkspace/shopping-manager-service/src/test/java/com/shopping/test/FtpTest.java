package com.shopping.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

import com.shopping.utils.FtpUtil;

public class FtpTest {
	@Test
	public void testFtp() throws FileNotFoundException {
		FtpUtil.uploadFile("192.168.191.3", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "/test/", "test.jpg", new FileInputStream("/home/wang/图片/壁纸/1122803682116979777.jpg"));
	}
}
