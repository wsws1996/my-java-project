package cn.wang.action;

import com.opensymphony.xwork2.Action;

public class HelloWroldAction {
	public String sayHello(){
		try {
			System.out.println("动作方法执行了le");
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}