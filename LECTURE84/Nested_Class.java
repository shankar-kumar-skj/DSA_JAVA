package JAVA.SHASHCODE.LECTURE84;

// class A{ // non static class OR outer class
// class B{ // static nested class OR inner class
//     }
// }

// NESTED CLASS
// 1. STATIC NESTED CLASS
// 2. INNER CLASS => non static nested class
//      (a) Member Inner Class (Regular Inner Class) => inside outer class but outside the funcyion body
//      (b) Anonymous Class => class without name
//      (a) Local Inner Class => inner class object creation then call

// A.B obj=new A.B() if static nested class
// A.B.display()  // static method
// obj.print() // non static method

class Outer{
    static int rollNumber;
    String name;
    private int age;
    int data;
    Outer(){
        rollNumber=100;
        this.name="skj";
        this.age=22;
        this.data=10;
        System.out.println("Init Outer");
    }

    public void displayData(){
        System.out.println("Outer Data is: "+data);
        Inner obj=new Inner();

    }

    // member inner class
    class Inner{
        static int rollNumber;
        // static String name;
        // int rollNumber;
        String name;
        int data;
        Inner(){
            name="Inner";
            this.data=20;
            System.out.println("Init Inner");
        }

        Inner(int data){
            name="inner";
            this.data=data;
        }

        public void displayData(){
            System.out.println("Data is: "+ data);
            System.out.println("Outer Data is: "+ Outer.this.data);
            System.out.println("Outer age is: "+ Outer.this.age);
            Outer.this.displayData();
        }

        public void displayRollNumber(){
            System.out.println("Outer RollNumber is: "+ Outer.rollNumber);
            System.out.println("Inner RollNumber is: "+ Inner.rollNumber);
        }
    }
    class InnerNew extends Inner{
      
    }
}

// Local Inner Class => no access specifiers, no static
class Fan{
    void display(){
        System.out.println("Outer display");
        class InnerFan{
            void display(){
                System.out.println("Inner display");
            }
        }
        InnerFan f=new InnerFan();
        f.display();
    }
}

class Normal{
    void display(){
        System.out.println("This is a Normal Class");
    }
}
abstract class NoName{
    abstract void display();
}

interface NoGame{
    void display();
}

class Outer{
    static int rollNumber;
    String name;
    private int age;
    int data;
}

class OuterNonStatic{
    static int age;
    // String name; // NON STATIC NOT ALLOWED
    static class InnerStatic{
        void display(){
            age=23;
            // name="E3";
            System.out.println("Non-Static Method inside Static Inner class");
            System.out.println("age : "+ age);
        }
    }

    static class InnerSecondStatic{
        static void display(){
        System.out.println("Static Method inside Non-Static Inner class");
        }
    }
}

public class Nested_Class {
    Outer obj1=new Outer();
    Outer.Inner innerObject=obj1.new Inner();

    // obj1.displayData();
    // innerObject.displayData();

    NoName nn= new NoName(){
        void display(){
            System.out.println("Annonymous class");
        }
        void print(){
            System.out.println("printed class");
        }
    };
    nn.display();
    nn.print();
    NoGame ng= new NoGame() {
        void display(){
        System.out.println("No game");
        } 
    };

    ng.display();

    OuterNonStatic ons=new OuterNonStatic();
    OuterNonStatic.InnerStatic obj=new OuterNonStatic.InnerStatic();
    obj.display();

    // no need of object
    OuterNonStatic.InnerSecondStatic.display();

    // no need of object 
    OuterNonStatic.InnerSecondStatic obj2=new OuterNonStatic.InnerSecondStatic();
    
}
