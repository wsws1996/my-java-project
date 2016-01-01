package junit.test;

public class Test {

	public static void main(String[] args) {
		System.out.println( Thread.currentThread());
		ThreadLocal threadLocal=new ThreadLocal<>();
		threadLocal.set("aaa");
		String value=(String)threadLocal.get();
		System.out.println(value);
	}

}
