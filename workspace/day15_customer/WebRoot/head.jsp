<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>页头</title>

</head>

<body style="text-align: center;">
	<h1>客户关系管理系统</h1>
	<br>
	<a
		href="${pageContext.request.contextPath }/servlet/AddCustomerUIServlet"
		target="body">添加客户</a>
	<a
		href="${pageContext.request.contextPath }/servlet/ListCustomerServlet"
		target="body"">查看客户</a>

</body>
</html>
