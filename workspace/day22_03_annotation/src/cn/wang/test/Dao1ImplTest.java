package cn.wang.test;

public class Dao1ImplTest {
	@MyTest
	/**
	 * 测试保存
	 * 
	 */
	public void save() {
		System.out.println("save");
	}
	@MyTest
	public void delete() {
		System.out.println("delete");
	}
}
class A extends Dao1ImplTest{
	
}