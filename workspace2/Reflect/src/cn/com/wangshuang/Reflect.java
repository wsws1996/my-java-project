package cn.com.wangshuang;

public class Reflect {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Person p=new Person();
		Class c=p.getClass();
		
		Person p2=new Person();
		Class c2=p2.getClass();
		System.out.println(p==p2);
		System.out.println(c==c2);
		Class c3=Person.class;
		System.out.println(c==c2);
		Class c4=Class.forName("cn.com.wangshuang.Person");
		System.out.println(c==c4);
	}

}
