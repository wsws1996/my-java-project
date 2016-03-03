<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户授予角色</title>
    
  </head>
  
  <body>
	<table border="1" width="60%">
		<tr>
			<td>用户名称</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>用户当前拥有的角色</td>
			<td><c:forEach var="r" items="${user_roles}">
					${r.name}<br>
				</c:forEach></td>
		</tr>
		<tr>
			<td>系统当前所有角色</td>
			<td>
			<form action="${pageContext.request.contextPath}/servlet/AddUserRoleServlet" method="post">
			<input type="hidden" name="user_id" value="${user.id}">
				<c:forEach var="r" items="${system_roles}">
						<input type="checkbox" name="role_id" value="${r.id}">${r.name}<br>
					</c:forEach>
					<input type="submit" value="授予角色">
					</form>
				</td>
		</tr>
	</table>
</body>
</html>
