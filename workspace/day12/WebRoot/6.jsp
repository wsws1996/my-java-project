<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP '6.jsp' starting page</title>

</head>

<body>
	<%-- 
	<%
		request.setAttribute("data", null);
	%>
	<%--  <c:out value="${data}" escapeXml="true" default="数据不存在"></c:out> --%>
	<c:set var="data" value="xxx" scope="page"></c:set>
	<%-- ${pageScope.data }
	<%
		Map map = new HashMap();
		request.setAttribute("map", map);
	%>
	<c:set property="data" value="yyyy" target="${map }"></c:set>
	${map.data }
	<c:set property="name" value="wang" target="${person }"></c:set>

	<%--<c:if test="${user==null}" var="b" scope="page"/>
	 ${b} --%>
	<c:if test="${user==null}" var="b" scope="page"></c:if>
	${b }

	<c:forEach var="num" begin="1" end="10" step="1">
		${num} 
	</c:forEach>
	<br>
	<br>
	<br>
	<br>
	<%
		List list = Arrays.asList("1", "2", "3");
		request.setAttribute("list", list);
	%>
	<c:forEach var="index" begin="0" end="${fn:length(list) }" step="1">
	${list[index] }
</c:forEach>
<c:url value="/servlet/ServletDemo1" var="servletDemo1">
	<c:param name="name" value="中国"></c:param>
	<c:param name="password" value="我是"></c:param>
</c:url>
<a href="${servletDemo1}">点点</a>
</body>
</html>
