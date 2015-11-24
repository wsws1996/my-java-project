<%@page import="cn.wang.login.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	欢迎您：
	<%
	User user = (User) session.getAttribute("user");
	if (user != null) {

		out.write(user.getUsername());
	}
%>
	<a href="/day07/login.html">登录</a>
</body>
</html>
