<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP '4.jsp' starting page</title>
    
  </head>
  
  <body>
	<script type="text/javascript">
		String.prototype.trim=function(){
			return this.replace(/(^\s*)|(\s*$)/g,"");
		}
		
		var s1="           aaa         ";
		alert("|"+s1+"|");
		alert("|"+s1.trim()+"|");
	</script>
  </body>
</html>
