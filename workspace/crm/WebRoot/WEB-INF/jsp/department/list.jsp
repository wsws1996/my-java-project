<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>list</title>
    <link href="css/sys.css" type="text/css" rel="stylesheet" />
  </head>
  
  <body>
  <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="39%" align="left">[部门管理]</td>
   
    <td width="57%"align="right">
       <a href="departmentAction_addUI.action"><img src="images/button/tianjia.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="6%" align="center">部门名称</td>
	<td width="6%" align="center">部门说明</td>
    <td width="7%" align="center">编辑</td>
   <td width="7%" align="center"><a href="departmentAction_deleteByOrder.action">按序删除</a></td>
  </tr>
  <s:iterator value="#departments">
	  <tr class="tabtd2">
	    <td align="center"><s:property value="name"/></td>
	    <td align="center"><s:property value="description"/></td>
	  	<td width="7%" align="center"><a href="#"><img src="images/button/modify.gif" class="img"></a></td>
	  </tr>
  </s:iterator>
  <%-- <s:iterator value="#map">
  	<tr>
  		<td><s:property value="%{value.name}"/></td>
  		<td><s:property value="%{value.description}"/></td>
  		<td><s:property value="%{key}"/></td>
  	</tr>
  </s:iterator>
  <s:iterator value="#list">
  	<s:iterator>
  		<tr>
  		<td><s:property value="%{value.name}"/></td>
  		<td><s:property value="%{value.description}"/></td>
  		<td><s:property value="%{key}"/></td>
  	</tr>
  	</s:iterator>
  </s:iterator>
  <s:iterator value="#map">
	<s:iterator value="value">
		<s:property value="name"/>
		<s:property value="description"/>
	</s:iterator>
  </s:iterator>
  <s:iterator value="#list">
  	<s:iterator>
		<s:iterator value="value">
			<s:iterator>
				<s:property value="name"/>
				<s:property value="description"/>
			</s:iterator>
		</s:iterator>  	
  	</s:iterator>
  </s:iterator> --%>
</table>
  </body>
</html>
