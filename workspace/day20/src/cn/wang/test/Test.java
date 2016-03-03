package cn.wang.test;

public class Test {

	public static void main(String[] args) {
		String filename="dfsgdfh";
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		System.out.println(dir1);
		System.out.println(dir2);
	}

}
