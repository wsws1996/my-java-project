<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '1.jsp' starting page</title>

</head>

<body>
	<s:text name="hello1"></s:text>
	<br>
	<s:i18n name="msg">
		<s:text name="hello"></s:text>
	</s:i18n>
	<br>
	<s:i18n name="cn.wang.package">
		<s:text name="hello"></s:text>
	</s:i18n>
	<s:i18n name="cn/wang/package">
		<s:text name="hello"></s:text>
	</s:i18n>
</body>
</html>
