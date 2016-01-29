package cn.test.wangshuang;

public class ToolDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Person p=new Person();
		Tool.setProperty(p, "name", "ÀîËÄ");
		Tool.setProperty(p, "age", 23);
		System.out.println(p);
		System.out.println("-------------");
		Dog d=new Dog();
		Tool.setProperty(d, "sex", 'ÄÐ');
		Tool.setProperty(d, "price", 12.50f);
		System.out.println(d);
	}

}
class Dog{
	char sex;
	float price;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return sex+"------"+price;
	}
}
class Person{
	private String name;
	public int age;
	@Override
	public String toString() {
		return name+"---"+age;
		
	}
}