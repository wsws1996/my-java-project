<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '1.jsp' starting page</title>

</head>

<body>
	欢迎您，${user.username}<br>
	<a href="/day19/servlet/AddProduct">添加商品</a>
	<a href="/day19/servlet/UpdateProduct">修改商品</a>
	<a href="/day19/servlet/DeleteProduct">删除商品</a>
</body>
</html>
