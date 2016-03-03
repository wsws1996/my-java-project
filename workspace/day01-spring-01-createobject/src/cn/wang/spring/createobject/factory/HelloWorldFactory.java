package cn.wang.spring.createobject.factory;

import cn.wang.spring.createobject.HelloWorld;

public class HelloWorldFactory {
	public static HelloWorld getInstance() {
		return new HelloWorld();
	}
}
