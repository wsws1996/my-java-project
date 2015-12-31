<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示所有用户</title>

</head>

<body style="text-align:  center;">
	<c:choose>
		<c:when test="${!empty(list)}">
			<table border="1">
				<tr>
					<td align="center">客户姓名</td>
					<td align="center">性别</td>
					<td align="center">生日</td>
					<td align="center">手机号码</td>
					<td align="center">邮箱</td>
					<td align="center">爱好</td>
					<td align="center">类型</td>
					<td align="center">备注</td>
					<td align="center">操作</td>
				</tr>
				<c:forEach var="c" items="${list}">
					<tr>
						<td align="center">${c.name }</td>
						<td align="center">${c.gender }</td>
						<td align="center">${c.birthday }</td>
						<td align="center">${c.cellphone }</td>
						<td align="center">${c.email }</td>
						<td align="center">${c.preference }</td>
						<td align="center">${c.type }</td>
						<td align="center">${c.description }</td>
						<td align="center"><a href="#">修改</a> <a href="#">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			对不起，系统还没有任何客户信息！！！
		</c:otherwise>
	</c:choose>
</body>
</html>
