<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '1.jsp' starting page</title>

</head>

<body>
	<%
		Map map=new HashMap();
		map.put("a", "aaaaaaxxxxx");
		map.put("bbb", "bbbb");
		map.put("c", "cccccccccc");
		request.setAttribute("map", map);
	 %>
	<c:forEach var="me" items="${map }">
		${me.key }=${me.value }<br>
	</c:forEach>
</body>
</html>
