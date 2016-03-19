(function(jQuery){
    jQuery.fn.myeach = function(callback){
        var array = $(this);
        for (var i = 0; i < array.length; i++) {
            callback.call($(array[i]), $(array[i]));
        }
    }
    jQuery.myeach = function(obj, callback){
        var array = $(obj);
        for (var i = 0; i < array.length; i++) {
            callback.call($(array[i]), $(array[i]));
        }
    }
})(jQuery);
$().ready(function(){
//    $("div").myeach(function(){
//        alert($(this).text());
//    });
    $.myeach($("div"), function(e){
        alert($(e).text());
    })
});
