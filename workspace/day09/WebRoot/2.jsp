<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>jsp:setproperty getproperty</title>

</head>

<body>
	<jsp:useBean id="person" class="cn.wang.Person" scope="page"></jsp:useBean>
	<jsp:setProperty property="name" name="person" value="wang" />
	<jsp:setProperty property="age" name="person" value="12" />
	<jsp:setProperty property="birthday" name="person" value="<%=new Date() %>" />
	<jsp:setProperty property="name" name="person" param="name"/>
	<jsp:setProperty property="*" name="person"/>
	<%
		/*System.out.println(person.getName());
		System.out.println(person.getPassword());
		System.out.println(person.getBirthday());
		System.out.println(person.getAge());*/
	%>
	<jsp:getProperty property="name" name="person"/>
</body>
</html>
