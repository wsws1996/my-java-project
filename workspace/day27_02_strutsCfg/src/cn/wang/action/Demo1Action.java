package cn.wang.action;

import com.opensymphony.xwork2.Action;

public class Demo1Action implements Action {

	@Override
	public String execute() throws Exception {
		try {
			System.out.println("动作方法执行了le");
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
	}
}
