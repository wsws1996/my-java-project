<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>el隐式对象</title>

</head>
<body>
	<%
		pageContext.setAttribute("name", "aaa");
	%>
	<!-- ${pageScope.name }  -->
	<%
		request.setAttribute("name", "bbb");
	%>
	<!-- ${requestScope.name } -->
	<%
		session.setAttribute("name", "ccc");
	%>
	<!-- ${sessionScope.name } -->
	<!-- ${param.name } -->
	<!-- <form
		action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
	<input type="text" name="username" value="${param.username }">
	<input type="submit"value="注册">
	</form> -->
	<%--${paramValues.like[0] }
	<br> ${paramValues.like[1] } --%>
	<%--${header.Accept }
	${header["Accept-Encoding"]} --%>
	<%--${cookie.JSESSIONID.value } --%>
	${initParam.root }
</body>
</html>
