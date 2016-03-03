<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '7.jsp' starting page</title>

</head>

<body>
	<s:property value="{'a','b','c'}.getClass()" />
	<br>
	<s:property value="#{'k1':'v1','k2':'v2' }.getClass()" />
	<hr>
	<s:radio name="gender" list="#{'1':'男','0':'女' }"></s:radio>
	<hr>
	<s:checkboxlist list="{'吃饭','睡觉','学习'}" name="hobby"></s:checkboxlist>
	<s:property value="'sex'" />
	<hr>
	<s:textfield name="username" label="%{姓名}"></s:textfield>
	<s:debug></s:debug>
</body>
</html>
