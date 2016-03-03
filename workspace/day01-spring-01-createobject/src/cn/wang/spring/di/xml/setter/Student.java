package cn.wang.spring.di.xml.setter;

import org.springframework.stereotype.Component;

@Component("student")
public class Student {
	public void say() {
		System.out.println("student");
	}
}
