<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>计算器</title>

</head>

<body style="text-align:center;">

	<jsp:useBean id="CalculatorBean" class="cn.wang.CalculatorBean"
		scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="CalculatorBean" />
	<%
		CalculatorBean.calculate();
	%>
	<br>
	<hr>
	<hr>
	计算结果是：
	<jsp:getProperty property="firstNum" name="CalculatorBean" />
	<jsp:getProperty property="operator" name="CalculatorBean" />
	<jsp:getProperty property="secondNum" name="CalculatorBean" />
	=
	<jsp:getProperty property="result" name="CalculatorBean" />
	<br>
	<hr>
	<hr>
	<form action="/day09/calculator.jsp" method="post">
		<table border="1" width="50%">
			<tr>
				<td colspan="2">简单计算器</td>
			</tr>
			<tr>
				<td>第一个参数</td>
				<td><input type="text" name="firstNum"></td>
			</tr>
			<tr>
				<td>运算符</td>
				<td><select name="operator">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
				</select></td>
			</tr>
			<tr>
				<td>第二个参数</td>
				<td><input type="text" name="secondNum"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="计算"></td>
			</tr>
		</table>
	</form>
</body>
</html>
