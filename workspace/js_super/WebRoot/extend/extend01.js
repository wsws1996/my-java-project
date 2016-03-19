function Student(){

}

Student.prototype.setName = function(name){
    this.name = name;
}
Student.prototype.getName = function(){
    return this.name;
}

function SuperStudent(){

}

//SuperStudent.prototype = Student.prototype;
SuperStudent.prototype = new Student();

var superStudent = new SuperStudent();
superStudent.setName("aaa");
alert(superStudent.getName());
