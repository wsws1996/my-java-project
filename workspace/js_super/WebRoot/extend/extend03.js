namespace("org.wang");
org.wang.extend = function(json, prop){
    function F(){
    
    }
    
    if (typeof json == "object") {
        for (var i in json) {
            F.prototype[i] = json[i];
        }
    }
    
    if (typeof json == "function") {
        F.prototype = json.prototype;
        for (var j in prop) {
            F.prototype[j] = prop[j];
        }
    }
    return F;
}

var Person = org.wang.extend({
    aa: 'aa',
    bb: 'bb'
});
var p = new Person();
alert(p.aa);

var SuperPerson = org.wang.extend(Person, {
    cc: 'cc'
});

var sp = new SuperPerson();
alert(sp.cc);
