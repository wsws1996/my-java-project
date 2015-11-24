package cn.wang;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.inject.New;

import sun.misc.BASE64Encoder;

import com.sun.mail.util.BASE64EncoderStream;


public class Demo {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String token="hfghfg";
		MessageDigest md= MessageDigest.getInstance("md5");
		byte md5[]= md.digest(token.getBytes());
		System.out.println((new BASE64Encoder()).encode(md5));
		
	}

}
