<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="/wang" prefix="wang"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示所有用户</title>

</head>

<body style="text-align:  center;">
	<c:choose>
		<c:when test="${!empty(page.list)}">
			<table border="1" style="margin: auto;">
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
				<c:forEach var="c" items="${page.list}">
					<tr>
						<td align="center"><c:out value="${c.name}"></c:out></td>
						<td align="center"><c:out value="${c.gender}"></c:out></td>
						<td align="center"><c:out value="${c.birthday}"></c:out></td>
						<td align="center"><c:out value="${c.cellphone }"></c:out></td>
						<td align="center"><c:out value="${c.email }"></c:out></td>
						<td align="center"><c:out
								value="${wang:subString(c.preference,10)}"></c:out></td>
						<td align="center"><c:out value="${c.type }"></c:out></td>
						<td align="center"><c:out
								value="${wang:subString(c.description,10)}"></c:out></td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/servlet/UpdateCustomerUIServlet?id=${c.id}">修改</a>
							<a href="javascript:dodelete('${c.id}')">删除</a></td>
					</tr>
				</c:forEach>
			</table>

			<%@include file="/public/page.jsp"%>
		</c:when>
		<c:otherwise>
			对不起，系统还没有任何客户信息！！！
		</c:otherwise>
	</c:choose>
</body>
<script type="text/javascript">
	function dodelete(id) {
		var b = confirm("您确认删除吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath}/servlet/DeleteCustomerServlet?id="
					+ id;
		}
	}
</script>
</html>
