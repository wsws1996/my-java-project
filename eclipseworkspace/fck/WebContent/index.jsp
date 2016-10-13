<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="res/js/jquery.js"></script>
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	$(function() {
		var fck = new FCKeditor("myTextArea");
		fck.ToolbarSet="myTool";
		fck.BasePath="res/fckeditor/";
		fck.ReplaceTextarea();
	});
</script>
</head>
<body>
	<textarea rows="" cols="" id="myTextArea"></textarea>
</body>
</html>