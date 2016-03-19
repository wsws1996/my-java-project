(function($){
	$.alert=function(msg){
		window.alert(msg+"!!!");
	}
	$.fn.alert=function(msg){
		window.alert("fn:"+msg+"!!!");
	}
})($);
$().ready(function(){
	$.alert("aaa");
	$("br").alert("aaa");
	
});
