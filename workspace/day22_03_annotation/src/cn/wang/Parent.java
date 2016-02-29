package cn.wang;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings({ "all" })
public class Parent {
	public void m1(){
		Date date=new Date();
	}
	@Deprecated
	public void llllll1111lll() {
		
	}
}
class Child extends Parent{
	public void m1() {
		
	}
	@Override
	public void llllll1111lll(){
		
	}
	@SuppressWarnings({ "all" })
	public void m2() {
		int i=10;
		List list=new ArrayList();
	}
}
