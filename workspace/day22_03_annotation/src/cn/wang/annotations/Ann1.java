package cn.wang.annotations;


public @interface Ann1 {
	String name();

	int age() default 18;
	// Date birthday();// 注解属性的类型只能是基本类型、String、Class、注解、枚举以及以上类型的一维数组
}

class Demo1 {
	@Ann1(name = "张三", age = 28)
	public void m1() {

	}
}