<%@page import="cn.wang.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>el表达式运算符</title>

</head>

<body>
	<%--${365*24 } ${user==null } ${username==null &&usr==null }--%>
	<%
		List list = null;
			//User user = new User();
			/*user.setUsername("vvv");
			request.setAttribute("user", user);*/
	%>
	<%--
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		request.setAttribute("list", list);
	--%>
	<c:if test="${!empty(list) }">
		<c:forEach var="str" items="${list }">
			${str }
		</c:forEach>
	</c:if>
	<c:if test="${empty(list) }">
		对不起，没有数据
	</c:if>

	<br>
	<br>
	<br> ${user==null ?"对不起，您没有登录" : user.username }
	
	<%
		User user=new User();
		user.setGender("male");
		request.setAttribute("user", user);
	 %>
	
	<input type="radio" name="gender" value="male" ${user.gender=="male"?"checked":""}>男
	<input type="radio" name="gender" value="female" ${user.gender=="female"?"checked":""}>女
	<br> 
	<br> 
	<br> 
	<br> 
	<%
		user=new User();
		String likes[]={"sing","dance","football"};
		user.setLikes(likes);
		request.setAttribute("user", user);
	 %>
	 <input type="checkbox" name="like" value="sing" ${ }>唱歌
	 <input type="checkbox" name="like" value="sing">跳舞
	 <input type="checkbox" name="like" value="sing">篮球
	 <input type="checkbox" name="like" value="sing">足球
	 

</body>
</html>
