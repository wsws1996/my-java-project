package cn.wang.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {

	public Demo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle(
				"cn.wang.resourse.myproperties", Locale.ENGLISH);
		String username = bundle.getString("username");
		String password=bundle.getString("password");
		System.out.println(username);
		System.out.println(password);
	}

}
