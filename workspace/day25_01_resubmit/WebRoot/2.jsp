<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.wang.cn/token" prefix="wang" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '1.jsp' starting page</title>
    
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/servlet/ServletDemo2">
		<input name="name"/><br>
		<wang:token/>
		<input type="submit" value="提交">
	</form>
  </body>
</html>
