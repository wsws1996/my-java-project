<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>书籍列表</title>

</head>

<body style="text-align: center;">
	<h2>书籍列表</h2>
	<br>
	<br>
	<table border="1" bordercolor="pink" style="text-align: center;" width="80%">
		<tr>
			<td>书籍编号</td>
			<td>书名</td>
			<td>作者</td>
			<td>售价</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach var="me" items="${map }">
			<tr>
				<td>${me.key }</td>
				<td>${me.value.name }</td>
				<td>${me.value.author }</td>
				<td>${me.value.price }</td>
				<td>${me.value.description }</td>
				<td><a href="${pageContext.request.contextPath }/servlet/BuyServlet?bookid=${me.key}">购买</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
