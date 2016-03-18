function Person(){

}

Person.prototype.aa = "aa property";
Person.prototype.bb = function(){
    alert("bb function");
};
var p = new Person();
p.bb();
alert(p.aa);

var json = {};
alert(json.prototype);

function Student(){

}

Student.prototype.setId = function(id){
    this.id = id;
}
Student.prototype.setName = function(name){
    this.name = name;
}
Student.prototype.getId = function(){
    return this.id;
}
Student.prototype.getName = function(){
    return this.name;
}

var s = new Student();
s.setId(4);
s.setName("dgf");
alert(s.getId());
alert(s.getName());

s.bb=5;
alert(s.bb);
var ss=new Student();
alert(ss.bb);
