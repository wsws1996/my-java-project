<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'register.jsp' starting page</title>
    
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/customer/register.action" method="post">
	用户名：<input type="text" name="customers[0].username"> &nbsp;&nbsp; 
	密码：<input type="password" name="customers[0].password"><br>
	用户名：<input type="text" name="customers[1].username"> &nbsp;&nbsp; 
	密码：<input type="password" name="customers[1].password"><br>
	用户名：<input type="text" name="customers[2].username"> &nbsp;&nbsp; 
	密码：<input type="password" name="customers[2].password"><br>
	<input type="submit" value="登录">
	</form>
	<form action="${pageContext.request.contextPath}/customer/register1.action" method="post">
	用户名：<input type="text" name="customers1['c1'].username"> &nbsp;&nbsp; 
	密码：<input type="password" name="customers1['c1'].password"><br>
	用户名：<input type="text" name="customers1['c2'].username"> &nbsp;&nbsp; 
	密码：<input type="password" name="customers1['c2'].password"><br>
	用户名：<input type="text" name="customers1['c3'].username"> &nbsp;&nbsp; 
	密码：<input type="password" name="customers1['c3'].password"><br>
	<input type="submit" value="登录">
	</form>
  </body>
</html>
