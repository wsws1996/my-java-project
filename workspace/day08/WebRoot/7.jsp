<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>pageContext访问其他域</title>
    
  </head>
  
  <body>
    <%
    	pageContext.setAttribute("data", "xxx1", pageContext.SESSION_SCOPE);
    	//String data=(String)pageContext.getAttribute("data", pageContext.SESSION_SCOPE);
    	String data=(String)pageContext.findAttribute("data");
     %>
     <%=data %>
  </body>
</html>
