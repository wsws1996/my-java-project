<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'form.jsp' starting page</title>

</head>

<body>
	<form action="/day08/servlet/DoFormServlet">
		<input type="hidden" name="token" value="<%=session.getAttribute("token") %>"> 用户名：<input type="text" name="username">
		<input type="submit" value="提交">
	</form>
</body>
</html>
