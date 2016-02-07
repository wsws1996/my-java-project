<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>AJAX测试异步交互</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/util.js"></script>
<script type="text/javascript">
	window.onload=function(){
		document.getElementById("bt1").onclick=function(){
			var xhr=getXHR();
			xhr.onreadystatechange=function(){
				if (xhr.readyState==4) {
					if (xhr.status==200) {
						alert("服务器响应结束");
					}
				}
			}
			xhr.open("GET","${pageContext.request.contextPath}/servlet/ServletDemo1?time="+new Date().getTime());
			xhr.send(null);//没有正文
		}
	}
</script>
</head>

<body>
	<input id="bt1" type="button" value="点击">
</body>
</html>
