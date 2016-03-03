<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>显示所有商品:JSON</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/util.js"></script>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("bt1").onclick = function() {
			var xhr = getXHR();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var text =xhr.responseText;
						var products=eval("("+text+")");
						document.getElementById("d1").innerHTML="<table id='t1' border='1' width='438'><tr><th>编号</th><th>名称</th><th>价格</th></tr>"
						for (var i = 0; i < products.length; i++) {
							var p=products[i];
							var row=document.getElementById('t1').insertRow(i+1);
							var cell=row.insertCell(0);
							cell.innerHTML=p.id;
							cell=row.insertCell(1);
							cell.innerHTML=p.name;
							cell=row.insertCell(2);
							cell.innerHTML=p.price;
						}
					}
				}
			}
			xhr.open("GET",
					"${pageContext.request.contextPath}/servlet/ServletDemo5");
			xhr.send(null);
		}
	}
</script>

</head>

<body>
	<input type="button" id="bt1" value="显示商品">
	<hr />
	<div id="d1"></div>
</body>
</html>
