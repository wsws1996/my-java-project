package cn.wang.generic;

public class GenericDemo1 {
	//<T>是声明的泛型类型，放在返回值的前面
	public <T> T m1() {
		return null;
	}
	public <T> void m2(T t) {
	}
	public <T> void m3(Class<T> clazz) {
	}
}
