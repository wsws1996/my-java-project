package cn.wang.annotations;

public @interface Ann2 {
	String url() default "";

	Param[] params();
}
//嵌套注解使用
class demo2 {
	@Ann2(url = "/servlet/Demo1", params = { @Param(name = "encoding", value = "UTF-8", desciption = "编码") })
	public void m1() {

	}
}