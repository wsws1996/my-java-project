<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>列出所有学生</title>
    
  </head>
  
  <body style="text-align: center;">
  <c:choose>
	<c:when test="${!empty(page.list)}">
		<table border="1" style="margin: auto;">
			<tr>
				<td align="center">ID</td>
				<td align="center">学生姓名</td>
			</tr>
			<c:forEach var="c" items="${page.list}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/public/page.jsp" %>
	</c:when>
	<c:otherwise>
		对不起，系统还没有学生信息！！！
	</c:otherwise>
  </c:choose>
  </body>
</html>
