package cn.wang.demo;

public class Demo2 {

	public static void main(String[] args) {
		int x = 2147483647;
		int y = 2147483646;

//		x = x + y;
//		y = x - y;
//		x = x - y;

		x = x ^ y;
		y = x ^ y;
		x = x ^ y;

		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}

}
