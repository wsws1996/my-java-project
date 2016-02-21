<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '1.jsp' starting page</title>
<style type="text/css">
.b {
	background-color: f3c3f3;
}

.r {
	background-color: c3f3c3;
}
</style>
</head>

<body>
	<s:url action="demo2" var="u1">
		<s:param name="username" value="'你好'"></s:param>
	</s:url>
	<a href="${u1 }">...2</a>
	<s:a action="demo2">...12
		<s:param name="gg" value="'没有货'"></s:param>
	</s:a>
	<s:debug></s:debug>
</body>
</html>
