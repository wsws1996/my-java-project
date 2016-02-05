<%@page import="cn.wang.domain.MyBean2"%>
<%@page import="cn.wang.domain.MyBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	当前在线用户人数：${applicationScope.num}
	<%
	/*
		session.setAttribute("name", "xxx");
		session.setAttribute("name", "yyy");
		session.removeAttribute("name");

		request.setAttribute("name", "xxx");
		request.setAttribute("name", "yyy");
		request.removeAttribute("name");*/

		/*session.setAttribute("bean", new MyBean());
		session.removeAttribute("bean");*/
		session.setAttribute("bean", new MyBean2());
	%>
	
	
		<a href="<c:url value="/jsp/index.jsp?gh=中国"/>">dd</a>
		<a href="/jsp/index.jsp?gh=中国">dd</a>
</body>
</html>
