package cn.wang.generic;



//类上声明泛型类型,实例方法就可以直接使用了，但静态方法不可,静态方法必须先声明再使用
public class GenericDemo2<T, G, D> {
	// <T>是声明的泛型类型，放在返回值的前面
	public T m1() {
		return null;
	}

	public void m2(T t) {
	}

	public void m3(Class<T> clazz) {
	}
	public static<O> void name(O o) {
		
	}
	public static <K,V> V getKey(K k) {
		return null;
	}
}
