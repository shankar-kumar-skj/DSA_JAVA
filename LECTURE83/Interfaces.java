package JAVA.SHASHCODE.LECTURE83;

//  for earilear versions not JAVA - 8 OR JAVA - 9

// interface needs implementation all methods implementation with body
//  main inferace don't conatin constructor, object creation not allowed 
// all the variables include the interface must have public, static, final => By Default
// all the methods include the interface must have public, Abstract => By Default
// INTERFACE IS USED TO SOLVE MULTIPLE INHERITANCE PROBLEM.
// Java 8 
// => static Non Abstarct methods+ default  Non Abstarct method addition possible with body

// Java 9
// => private Non Abstarct methods addition possible with body

interface MyInterface_Shape{
    String name="Interface";
    void calculateArea();
    void display();

    // private void greetUser(){
    //     System.out.println("Welcome user");
    // }

    // default void printSome(){
    //     greetUser();
    // }

    static void printName(){
        System.out.println("Welcome user");
    }

}

class Circle implements MyInterface_Shape,intermediate{
    private final double pi=3.14;
    int radius;
    Circle(){
        this.radius=10;
    }
    public void display(){
        System.out.println("Shape is Circle!");
    }
    public void calculateArea(){
        System.out.println("Area : "+pi*radius*radius);
    }

    public void fillArea(){
        System.out.println("Filled Area!");
    }
}


// calling one interface from other interface
// interface intermediate extends Shape {
//     void fillArea();
  
// }
interface intermediate{
    void fillArea();
  
}

public class Interfaces {
    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.calculateArea();
        circle.display();
        // circle.printSome();

        // Shape shape=new Circle();
        // shape.printSome();

    }
}
