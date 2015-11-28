<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/simplewang" prefix="wang" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>如果标签接受的是一个复杂类型，给其赋值</title>

</head>

<body>
<%
	Date d=new Date();
	request.setAttribute("date", d);
 %>
	<wang:demo6 date="${date }"></wang:demo6>
	<wang:demo6 date="<%=new Date() %>"></wang:demo6>
</body>
</html>
