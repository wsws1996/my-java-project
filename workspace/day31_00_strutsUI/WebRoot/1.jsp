<%@page import="cn.wang.domain.Customer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '1.jsp' starting page</title>
    <s:head/>
  </head>
  
  <body>
	<s:form action="" namespace="">
		<s:textfield name="username" ></s:textfield>
		<s:checkboxlist name="hobby" list="#{'eat':'吃饭','sleep':'书籍'}" value="{'sleep','eat'}" label="爱好" ></s:checkboxlist>
		<s:radio list="{'m','f'}" name="gender" label="性别" value="'m'"></s:radio>
		<hr>
		<%
			List<Customer> customers=new ArrayList<Customer>();
			customers.add(new Customer(1,"通天塔"));
			customers.add(new Customer(2,"公关部"));
			customers.add(new Customer(3,"事实上"));
			request.setAttribute("cs", customers);
		%>
		<s:checkboxlist list="#request.cs" name="person" label="人" listKey="id" listValue="name"></s:checkboxlist>
		<s:select list="#request.cs" listKey="id" listValue="name" label="人"></s:select>
		<s:select list="{'g','y' }"></s:select>
	</s:form>
	<s:debug></s:debug>
  </body>
</html>
