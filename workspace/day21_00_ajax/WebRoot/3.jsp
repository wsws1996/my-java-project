<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示所有商品</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/util.js"></script>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("bt1").onclick = function() {
			var xhr = getXHR();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						document.getElementById("d1").innerHTML=xhr.responseText;
					} 
				}
			}
							xhr.open("GET","${pageContext.request.contextPath}/servlet/ServletDemo3");
			xhr.send(null);
		}
	}
</script>

</head>

<body>
	<input type="button" id="bt1" value="显示商品">
	<hr/>
	<div id="d1"></div>
</body>
</html>
