<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'test2.jsp' starting page</title>
    
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/servlet/ServletDemo2"
		method="post">
		留言：<br>
		<textarea rows="8" cols="60" name="message"></textarea>
		<br> <input type="submit" value="发表">
	</form>
</body>
</html>
