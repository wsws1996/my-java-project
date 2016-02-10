package cn.wang.annotations;

public @interface Ann3 {
	String name() default "";
	String value() default "";
}
//特殊属性value的使用，没有value不能使用@Ann3("abc")这种语法
class Demo3{
	@Ann3("abc")//给的是value
	public void m1() {
		
	}
	@Ann3(value="abc",name="def")
	public void m2() {
		
	}
}