(function(window){
    function Person(){
        return {
            setName: setName,
            getName: getName
        };
    }
    function setName(name){
        this.name = name;
    }
    function getName(){
        return this.name;
    }
    function aaa(){
    
    }
    function bbb(){
    
    }
    window.Person = Person;
})(window);
var Person=window.Person();

Person.setName("aaa");
alert(Person.getName());
