<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>add</title>
    <link href="css/sys.css" type="text/css" rel="stylesheet" />
  </head>
  
  <body class="emp_body">
  <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
	<s:form action="departmentAction_add.action">
<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="44%" align="left">[添加部门信息]</td>
   
    <td width="52%"align="right">
   	<input type="image" src="images/button/save.gif">
    <a href="#"><img src="images/button/tuihui.gif"/></a>
      
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"></td>
  </tr>
</table>
<table width="88%" border="0" class="emp_table" style="width: 80%">
  	<tr>
  		<td width="9%">部门名称：</td>
  		<td width="19%"><s:textfield name="name"></s:textfield></td>
  	</tr>
  	<tr>
  		<td width="9%">部门描述：</td>
  		<td width="19%"><s:textfield name="description"></s:textfield></td>
  	</tr>
</table>
</s:form>
  </body>
</html>
