package cn.wang.spring.initdestory;

public class Person {
	private String name;

	public Person() {
		System.out.println("new instance");
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("set Name");
		this.name = name;
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void destory() {
		System.out.println("destory");
	}

}
