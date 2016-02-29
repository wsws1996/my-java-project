package junit.test;

public class Test {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		threadLocal.set("aaa");
		String value = (String) threadLocal.get();
		System.out.println(value);
	}

}
