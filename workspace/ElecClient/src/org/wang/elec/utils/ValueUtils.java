package org.wang.elec.utils;

import org.apache.struts2.ServletActionContext;

public class ValueUtils {

	//将对象压入栈顶
	public static void putValueStack(Object object) {
		ServletActionContext.getContext().getValueStack().push(object);
	}
	
}
