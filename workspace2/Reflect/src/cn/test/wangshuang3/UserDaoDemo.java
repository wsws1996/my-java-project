package cn.test.wangshuang3;

public class UserDaoDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDaoimpl2 ud=new UserDaoimpl2();
		ud.add();
		ud.delete();
		ud.update();
		ud.find();
		System.out.println("--------");
		Student sd=new Studentimpl();
		sd.login();
		sd.regist();
	}

}
