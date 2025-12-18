package JAVA.SHASHCODE.LECTURE82;

// abstract class A{
//         // method contain decleraction not defination
//         abstract display();
//         // abstract => no object, constructor create
//         // constructor main works not to create object it works is to initialize object
//         // abstract class containing method can be static
//         // abstract class containing method can be final
//         // abstract method not be final => it not give premission to override and abstract is basically based on overriding.
//         // abstract method not be static => static methods not override so not possible.
//         // abstract method not be private => private methods not called so not possible.
// }

abstract class Bank{
    String message;
    Bank(){
        message="Sir!";
        System.out.println("this is constructor!"+ message);
    }
    abstract int rateOfInterest();
    void display(){
        System.out.println("Welcome to our Bank!");
    }
}

class Pnb extends Bank{
    int rateOfInterest(){
        return 10;
    }
}

class Sbi extends Bank{
    int rateOfInterest(){
        return 9;
    }
}

abstract class HDFC extends Bank{
    void print(){
        System.out.println("Hi HDFC!");
    }
}

class NewBank extends HDFC {
    int rateOfInterest(){
        return 20;
    }
}
public class Java_abstraction {
    // Hinding implementation details
    // abstract class => 0 to 100 %
    // interface => 100 %
    public static void main(String[] args){
        // Bank b=new Bank(); // cause error

        // Pnb p= new Pnb();
        // System.out.println(p.rateOfInterest());

        // Bank b=new Pnb();
        // System.out.println(b.rateOfInterest());
        // b.display();

        Bank b1=new Pnb();
        System.out.println(b1.rateOfInterest());
        
        Bank b2=new Sbi();
        System.out.println(b2.rateOfInterest());
        
        Bank b3=new NewBank();
        System.out.println(b3.rateOfInterest());
        

        
    }  
}
