package cn.wang.annotations;

public @interface Param {
	String name() default "";
	String value() default "";
	String desciption() default "";
}
