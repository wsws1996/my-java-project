package cn.test.wangshuang3;

public class UserDaoimpl2 implements UserDao {

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("权限校验");
		System.out.println("添加功能");
		System.out.println("日志记录");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("权限校验");
		System.out.println("删除功能");
		System.out.println("日志记录");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("权限校验");
		System.out.println("更新功能");
		System.out.println("日志记录");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("权限校验");
		System.out.println("查找功能");
		System.out.println("日志记录");
	}
}
