<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'test.jsp' starting page</title>
    
  </head>
  
  <body>
  <c:url value="/servlet/ServletDemo1" scope="page" var="servletDemo1">
  		<c:param name="username" value="中国"></c:param>
  	</c:url>
	<a href="${servletDemo1}">点点</a>
  	<form action="${pageContext.request.contextPath}/servlet/ServletDemo1" method="post">
  	用户名：<input type="text" name="username">
  	<input type="submit" value="提交">
  	</form>
  </body>
</html>
