package cn.wang.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class testmd5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("md5");
		System.out.println(byte2hex(messageDigest.digest("123".getBytes())));
		System.out.println(byte2hex(messageDigest.digest("123".getBytes())));
		System.out.println(byte2hex(messageDigest.digest("123".getBytes())));
	}

	public static String byte2hex(byte[] b) // 二行制转字符串
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}

		return hs.toUpperCase();
	}

}
