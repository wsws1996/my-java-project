<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>省市二级联动</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/util.js"></script>
<script type="text/javascript">
	var xmlDoc;
	window.onload=function(){
		var xhr=getXHR();
		xhr.onreadystatechange=function(){
			if (xhr.readyState==4) {
				if (xhr.status==200) {
					xmlDoc = xhr.responseXML;
					var xmlProvinces = xmlDoc.getElementsByTagName("province");
					for (var i = 0; i < xmlProvinces.length; i++) {
						var codeValue=xmlProvinces[i].getAttribute("code");
						var nameValue=xmlProvinces[i].getAttribute("name");
						var o=new Option(nameValue,codeValue);
						document.getElementById("p1").add(o);
					}
				}
			}
		}
		xhr.open("GET","${pageContext.request.contextPath}/servlet/ServletDemo4?time="+new Date().getTime());
		xhr.send(null);
	}
	function selectCity(provinceObj) {
		var selectValue=provinceObj.value;
		document.getElementById("c1").length=1;
		var xmlProvinces=xmlDoc.getElementsByTagName("province");
		for (var i = 0; i < xmlProvinces.length; i++) {
			if (selectValue == xmlProvinces[i].getAttribute("code")) {
				var xmlCitys= xmlProvinces[i].getElementsByTagName("city");
				for (var j = 0; j < xmlCitys.length; j++) {
					var codeValue=xmlCitys[j].getAttribute("code");
					var nameValue=xmlCitys[j].getAttribute("name");
					var o=new Option(nameValue,codeValue);
					document.getElementById("c1").add(o);
				}
			}
		}
	}
</script>
</head>

<body>
	省份：<select id="p1" onchange="selectCity(this)">
		<option value="">--请选择--</option>
	</select>
	城市：<select id="c1">
		<option value="">--请选择--</option>

	</select>
</body>
</html>
