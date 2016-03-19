namespace("org.wang");
org.wang.extend = function(json){
    function F(){
    
    }
    for (var i in json) {
        F.prototype[i] = json[i];
    }
    return F;
}

//var Person = extend({
//    aa: 'aa',
//    bb: 'bb'
//});
var Person =org.wang.extend({
	aa:'aa',
	bb:'bb'
});
var p = new Person();
alert(p.bb);
