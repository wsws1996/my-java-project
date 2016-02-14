<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'sure.jsp' starting page</title>
    
  </head>
  
  <body>
	<form action="https://www.yeepay.com/app-merchant-proxy/node">
		<input type="text" name="p0_Cmd" value="${p0_Cmd }">
		<input type="text" name="p1_MerId" value="${p1_MerId }">
		<input type="text" name="p2_Order" value="${ p2_Order}">
		<input type="text" name="p3_Amt" value="${p3_Amt }">
		<input type="text" name="p4_Cur" value="${p4_Cur }">
		<input type="text" name="p5_Pid" value="${p5_Pid }">
		<input type="text" name="p6_Pcat" value="${p6_Pcat }">
		<input type="text" name="p7_Pdesc" value="${p7_Pdesc }">
		<input type="text" name="p8_Url" value="${p8_Url }">
		<input type="text" name="p9_SAF" value="${p9_SAF }">
		<input type="text" name="pa_MP" value="${ pa_MP}">
		<input type="text" name="pr_NeedResponse" value="${pr_NeedResponse }">
		<input type="text" name="pd_FrpId" value="${pd_FrpId }">
		<input type="text" name="hmac" value="${hmac }">
		<input type="submit" value="提交">
	</form>
  </body>
</html>
