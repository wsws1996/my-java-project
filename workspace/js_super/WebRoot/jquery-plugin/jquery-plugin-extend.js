(function(jQuery){
    jQuery.fn.myextend = function(json){
        for (var i in json) {
            jQuery.fn[i] = json[i];
        }
    }
    jQuery.myextend = function(json){
        for (var i in json) {
            jQuery[i] = json[i];
        }
    }
})(jQuery);
$().ready(function(){
    $("body").myextend({
        aa: function(){
            alert("aaa");
        }
    });
	$("br").aa();
});

