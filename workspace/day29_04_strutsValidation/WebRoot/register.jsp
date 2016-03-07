<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'register.jsp' starting page</title>
</head>

<body>
	<s:debug></s:debug>
	<s:fielderror></s:fielderror>
	<s:form action="register" namespace="/student">
		<s:textfield name="username" label="用户名" required="true"
			requiredposition="left"></s:textfield>
		<s:password name="password" label="密码" showPassword="true" required="true"
			requiredposition="left"></s:password>
		<s:radio list="#{'male':'男','female':'女'}" name="gender" label="性别"
			required="true" requiredposition="left"></s:radio>
		<s:checkboxlist name="hobbies" list="{'吃饭','睡觉','学习'}" label="爱好"></s:checkboxlist>
		<s:textfield name="birthday" label="出生日期"></s:textfield>
		<s:textfield name="email" label="邮箱"></s:textfield>
		<s:textfield name="grade" label="成绩"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form>
	<br>
	<form action="${pageContext.request.contextPath}/student/register"
		method="post">
		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" />男 <input type="radio" name="gender"
					value="female" />女</td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td><input type="checkbox" name="hobbies" value="吃饭">吃饭
					<input type="checkbox" name="hobbies" value="睡觉">睡觉 <input
					type="checkbox" name="hobbies" value="学习">学习</td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input type="text" name="birthday"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>成绩：</td>
				<td><input type="text" name="grade"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
</body>
</html>
