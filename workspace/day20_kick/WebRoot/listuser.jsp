<%@page import="cn.wang.domain.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'listuser.jsp' starting page</title>

</head>

<body>
	当前网站在线用户：
	<c:forEach var="me" items="${map}">
		<%
			/*Map.Entry me = (Map.Entry) pageContext.getAttribute("me");
				HttpSession s = (HttpSession) me.getValue();
				if(session!=null){
				User user= (User)s.getAttribute("user");
				String username=user.getUsername();
				out.write(username);
				}*/
		%>
		${me.key}
		<a href="${pageContext.request.contextPath}/servlet/KickUserServlet?username=${me.key}"
			>踢人</a>
		<br>
	</c:forEach>

</body>
</html>
