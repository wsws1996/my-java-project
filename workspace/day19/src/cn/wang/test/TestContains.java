package cn.wang.test;

import java.util.ArrayList;
import java.util.List;

public class TestContains {
	public static void main(String[] args) {
		List<Person> persons=new ArrayList<Person>();
		Person person=new Person();
		persons.add(new Person());
		persons.add(new Person());
		persons.add(new Person());
		if (persons.contains(new Person())) {
			System.out.println("OK");
		}
	}
}
