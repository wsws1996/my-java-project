package cn.com.wangshuang2;

public class Person {
	private String name;
	int age;
	public String address;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	private Person(String name){
		this.name=name;
	}
	Person(String name,int age){
		this.age=age;
		this.name=name;
	}
	public Person(String name,int age,String address){
		this.age=age;
		this.name=name;
		this.address=address;
	}
	public void show() {
		System.out.println("show");
	}
	public void show(String s) {
		System.out.println("method:"+s);
	}
	public String getString(String s,int i) {
		return s+"---"+i;
	}
	private void function() {
		System.out.println("function");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}
}
