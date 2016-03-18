function Person(){

}

Person.a = 5;
function Student(){
	
}
Person.b=Student;

var json={
	aa:'bb'
};
Person.c=json;
//alert(Person.c.aa);

function A(){
	
}
function b(){
	
}
function c(){
	
}
function d(){
	
}
function e(){
	alert("hello world");
}
A.B=b;
A.B.C=c;
A.B.C.D=d;
A.B.C.D.E=e;


var AA={};
AA.BB=b;
AA.BB.CC=c;
AA.BB.CC.DD=d;
AA.BB.CC.DD.EE=e;
//AA.BB.CC.DD.EE();

 
function namespace(namespaceString){
	var temp=[];
	var array= namespaceString.split(".");
	for(var i=0;i<array.length;i++){
		temp.push(array[i]);
		eval("window."+temp.join(".")+"=function(){}");
	}
}
var tempnamespace = namespace("org.wang.g.sdg.sdfs");
