<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<title>rest测试</title>
<script type="text/javascript">

function rest() {
	$.ajax({
		type:'get',
		url:'http://localhost:8080/ws_02_cxf_spring_rest_server/ws/rest/student/querylist/5?_type=json',
		success:function(data){
			alert(data.student[0].name);
		}
	});
}

</script>
</head>
<body>
	<input type="button" value="rest请求" onclick="rest()">
</body>
</html>