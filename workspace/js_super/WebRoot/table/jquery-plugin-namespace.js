(function($){
    $.nameSpace = function(namespaceString){
        var temp = [];
        var array = namespaceString.split(".");
        for (var i = 0; i < array.length; i++) {
            temp.push(array[i]);
            eval("window." + temp.join(".") + "={}");
        }
    }
})($);
