<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>角色授权</title>

</head>

<body>
	<table border="1" width="60%">
		<tr>
			<td>角色名称</td>
			<td>${role.name}</td>
		</tr>
		<tr>
			<td>角色当前拥有的权限</td>
			<td><c:forEach var="p" items="${role_privileges}">
					${p.name}<br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>系统当前所有权限</td>
			<td>
			<form action="${pageContext.request.contextPath}/servlet/AddRolePrivilegeServlet" method="post">
			<input type="hidden" name="role_id" value="${role.id}">
				<c:forEach var="p" items="${system_privileges}">
						<input type="checkbox" name="privilege_id" value="${p.id}">${p.name}<br>
					</c:forEach>
					<input type="submit" value="授权">
					</form>
				</td>
		</tr>
	</table>
</body>
</html>
