namespace("org.wang");
org.wang.extend = function(destination, source){
    if (typeof destination == "object") {
        if (typeof source == "object") {
            for (var i in source) {
                destination[i] = source[i];
            }
        }
    }
    if (typeof destination == "function") {
        if (typeof source == "object") {
            for (var i in source) {
                destination.prototype[i] = source[i];
            }
        }
        if (typeof source == "function") {
            destination.prototype = source.prototype;
        }
    }
    return destination;
}
var d = org.wang.extend({}, {
    aa: 'aa',
    bb: 'bb'
});
alert(d.aa);
