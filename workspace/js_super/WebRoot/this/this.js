function Person(){
    alert(this);
}

function Student(){
 
}

//Student.a = Person;
var json = {
    a: Person
};


Person.call(json);
Person.apply(Student);
