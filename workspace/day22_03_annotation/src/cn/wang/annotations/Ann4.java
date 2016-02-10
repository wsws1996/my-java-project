package cn.wang.annotations;

public @interface Ann4 {
	String [] value() default "";
}
//数组属性的使用
class Demo4{
	@Ann4("abc")
	public void m1() {
		
	}
	@Ann4({"abc","ggg"})
	public void m2() {
		
	}
}