<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '1.jsp' starting page</title>
    
  </head>
  
  <body>
  	<%
  		String token=UUID.randomUUID().toString();
  		request.getSession().setAttribute("token", token);
  	%>
	<form action="${pageContext.request.contextPath}/servlet/ServletDemo1">
		<input name="name"/><br>
		<input type="submit" value="提交">
		<input type="hidden" name="token" value="<%=token%>" >
	</form>
  </body>
</html>
