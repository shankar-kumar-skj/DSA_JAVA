package JAVA.SHASHCODE.LECTURE81;

// BAAP BETE PAR UNGLI UTHA SAKTA HA PAR
// BETA BAAP PAR UNGLI NAHI UTHA SAKTA HA PAR

// Parent p=new Parent();
// Child c=new Child();
// Parent p2=new Child();
// Child c2=new Parent(); X

// private method cannot be overriderd
// private and static run time bound

// Static Binding / Early Binding => final keyword 
// Dynamic Binding / Late Binding => final keyword gives error

// final keyword can be overloaded but not be overrided

// static is not overrided
// if both of the functions are static => it is hided
// if one of that is non static => it gives error
// if both of the functions are non-static => it is overriding

// constructor can not overriding

// can a override function to a non-overrided function => using super keyword

// //  single
// class Terminator1{
//     String pName;
//     int pAge;
//     Terminator1(){
//         System.out.println("Constructor is called");
//     } 

//     Terminator1(String pName){
//         this.pName=pName;
//         System.out.println("Parameterized Constructor of parent");
//     }

//     public void display(){
//         System.out.println("Parent name is "+pName);
//     }

//     public void displayAge(){
//         System.out.println("Parent age is "+pAge);
//     }
// }

// class Child extends Terminator1{
//     String cName;
//     int cAge;

//     Child(){
//         System.out.println("Constructor of child");
//     }

//     Child(String cName){
//         this.cName=cName;
//         System.out.println("Parameterized Construction of child");
//     }

//     public void display(){
//         System.out.println("Child Nmae : "+cName);
//     }

// }

//  single
class Terminator1{
    String pName;
    String name;
    int age;
    Terminator1(){
        System.out.println("Constructor is called");
    } 

    Terminator1(String name){
        this.name=name;
        System.out.println("Parameterized Constructor of parent");
    }

    public void display(){
        System.out.println("Parent name is "+name);
    }

    public void display2(){
        System.out.println("Parent name is "+pName);
    }

    public void displayAge(){
        System.out.println("Parent age is "+age);
    }

    public void setName(String name){
        this.name=name;
    }
}

class Child extends Terminator1{
    String cName;
    String name;
    int cAge;

    Child(){
        System.out.println("Constructor of child");
    }

    Child(String name){
        this.name=name;
        System.out.println("Parameterized Construction of child");
    }

    public void display(){
        System.out.println("Child Name : "+name);
    }

    final public void display2(){
        System.out.println("Child2 Name : "+cName);
    }

    public void setName(String name){
        this.name=name;
    }

}

public class Function_overriding{
    public static void main(String[] args) {

        Terminator1 t1=new Terminator1();
        t1.display();
        // Child c1=new Terminator1(); //child point out in parent not
        Terminator1 t2=new Child();
        t2.display(); // -> ?
        // Child c1=new Terminator1();
        Terminator1 t3=new Terminator1();
        t3.display();

        t3.name="shankar";
        t3.setName("E3");
        t3.display();
        t3.display2();

        Child c=new Child();
        c.display2();

    }
}