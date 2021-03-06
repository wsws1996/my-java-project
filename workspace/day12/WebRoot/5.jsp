<%@page import="cn.wang.User"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>使用Sun el函数</title>

</head>

<body>
	<%
		List list = Arrays.asList("1", "2", "3");
		request.setAttribute("list", list);
	%>
	${fn:length(list) } ${fn:length("aaaaa") }
	${fn:split("aaa.bbb.ccc",".")[0]}
	${fn:join(fn:split("www,wang,com",","),".")}
	<br>
	<br>
	<br>
	<br>
	<%
		User user = new User();
		String likes[] = { "sing", "dance"};
		user.setLikes(likes);
		request.setAttribute("user", user);
	%>
	<input type="checkbox" name="like" value="sing" ${fn:contains(fn:join(user.likes,","),"sing")?"checked":"" } >唱歌
	<input type="checkbox" name="like" value="dance" ${fn:contains(fn:join(user.likes,","),"dance")?"checked":"" }>跳舞
	<input type="checkbox" name="like" value="basketball" ${fn:contains(fn:join(user.likes,","),"basketball")?"checked":"" } >篮球
	<input type="checkbox" name="like" value="football" ${fn:contains(fn:join(user.likes,","),"football")?"checked":"" }>足球

${fn:escapeXml("<a href=''>点点</a>") }
<a href="">点点</a>

</body>
</html>
