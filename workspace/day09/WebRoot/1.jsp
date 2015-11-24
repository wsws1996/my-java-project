<%@page import="cn.wang.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>jsp:usebean标签</title>

</head>

<body>
<%
	pageContext.setAttribute("person", new Person());
 %>
	<jsp:useBean id="person" class="cn.wang.Person" scope="page">
	xxx
	</jsp:useBean>
	<%
		System.out.println(person.getName());
	%>
</body>
</html>
