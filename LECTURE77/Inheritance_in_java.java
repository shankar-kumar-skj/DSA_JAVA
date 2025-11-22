package JAVA.SHASHCODE.LECTURE77;

// => Single Inhertiance -> Base Class (Patent class) <--extends--- Derived Class (child class)

// => Multi level Inheritance -> Base Class (Patent class) <--extends--- Derived Class1 (child1 class) (Child2 class Parents) <--extends--- Derived Class2 (child2 class)

//  Hierarical Inheritance ==> one Base Class (Patent class) <--extends--- Multiple Derived Class (child class) 
//                         -> Base Class (Patent class) <--extends--- Derived Class1 (child1 class)
//                         -> Base Class (Patent class) <--extends--- Derived Class2 (child2 class)
//                         -> Base Class (Patent class) <--extends--- Derived Class3 (child3 class)

// X Multiple Inheritance (diamond problem) ==> Multiple Parents <--extends--- one Derived Class (child class)
//                   ==> Multiple Inheritance using Interfaces

// Hybrid Inheritance => combination of 2 Inheritance in One.

// Inheritance => is a relationship


// single level Inheritance :-

class Terminator{
    String pName;
    int pAge;
    public void displayParent(){
        // displayAge(); //calling using member function
        System.out.println("Parent name is: "+pName);
    }
//  data hiding => restricting access
    private void displayAge(){
        System.out.println("Parent age is: "+pAge);
    }
}

class Child extends Terminator{
    String cName;
    int cAge;

    public void displayChild(){
        System.out.println("Child name is: "+cName+ "\nChild age : "+cAge );
    }
}

// Multi Level Inheritance

class Terminator1{
    String pName1;
    int pAge1;
    public void displayParent1(){
        // displayAge(); //calling using member function
        System.out.println("Parent name is: "+pName1);
    }
//  data hiding => restricting access
    private void displayAge1(){
        System.out.println("Parent age is: "+pAge1);
    }
}

class Child1 extends Terminator1{
    String cName1;
    int cAge1;

    public void displayChild1(){
        System.out.println("Child name is: "+cName1+ "\nChild age : "+cAge1);
    }
}
class Child2 extends Child1{
    String cName2;
    int cAge2;

    public void displayChild1(){
        System.out.println("Child name is: "+cName2+ "\nChild age : "+cAge2);
    }
}

// Hybrid Inheritance

class Terminator2{
    String pName2;
    int pAge2;
    public void displayParent2(){
        // displayAge(); //calling using member function
        System.out.println("Parent name is: "+pName2);
    }
//  data hiding => restricting access
    private void displayAge2(){
        System.out.println("Parent age is: "+pAge2);
    }
}

class Child3 extends Terminator2{
    String cName3;
    int cAge3;

    public void displayChild3(){
        System.out.println("Child name is: "+cName3+ "\nChild age : "+cAge3);
    }
}
class Child5 extends Child3{
    String cName5;
    int cAge5;

    public void displayChild5(){
        System.out.println("Child name is: "+cName5+ "\nChild age : "+cAge5);
    }
}
class Child6 extends Child3{
    String cName6;
    int cAge6;

    public void displayChild6(){
        System.out.println("Child name is: "+cName6+ "\nChild age : "+cAge6);
    }
}


public class Inheritance_in_java {
    public static void main(String[] args) {

        // single level inheritance
        Terminator t=new Terminator(); 
        t.pName="Shankar"; // changes show in terminator object but not in child that inherate the terminator property 
        // child only inherited the property not the accessing the heap data store of that object 
        // object of parent and child are different.


        t.displayParent();

        Child c=new Child();
        c.displayParent(); 
        c.displayChild();

        // multilevel inheritance
        Terminator1 t1=new Terminator1();
        t1.pName1="Shankar";
        t1.displayParent1();

        Child1 c1=new Child1();
        c1.cName1="Skj";
        c1.displayChild1();
        c1.displayParent1();
 
        M1 m=new M1();
        m.display();
        m.hashCode(); //by default => all class inherited object class.
        Child3 c3=new Child3();
        c3.hashCode();


    }
}

// by default => all class inherited 
class M1{
    int age;
    public void display(){

    }
}
