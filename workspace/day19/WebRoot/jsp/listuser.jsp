<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>列出所有用户</title>

</head>

<body style="text-align: center;">
	<table width="100%">
		<tr>
			<td align="right"><a
				href="${pageContext.request.contextPath}/jsp/adduser.jsp">添加用户</a></td>
		</tr>
	</table>
	<table width="100%" border="1">
		<tr>
			<td>用户名称</td>
			<td>用户密码</td>
			<td>操作</td>
		</tr>
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.username}</td>
				<td>${u.password}</td>
				<td><a
					href="${pageContext.request.contextPath}/servlet/AddUserRoleUIServlet?user_id=${u.id}">用户授予角色</a>
					<a href="#">修改用户</a> <a href="#">删除用户</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
