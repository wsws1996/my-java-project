<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'listfile.jsp' starting page</title>
    
  </head>
  
  <body>
	<c:forEach var="me" items="${map}">
	<c:url value="/servlet/DownloadServlet" var="downurl">
		<c:param name="filename" value="${me.key}"></c:param>
	</c:url>
		${me.value} <a href="${downurl}">下载</a><br>
	</c:forEach>
  </body>
</html>
