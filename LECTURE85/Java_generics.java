package JAVA.SHASHCODE.LECTURE85;

public class Java_generics {

    // T -> TYPE
    // E -> Element
    // K -> Key
    // V -> Value

    public <E> void heyGen2(E element){
        System.out.println("Hi generics");
    }
    public <T> void heyGen(T element){
        System.out.println("Hi generics");
    }
    public static void main(String[] args) {
        // non generics 
    // IntegerDisplay obj1=new IntegerDisplay();
    // obj1.setNum(20);
    // obj1.display();

    // DoubleDisplay obj2=new DoubleDisplay();
    // obj2.setNum(20.0);
    // obj2.display();

            // generics
        // for integer
        Displayer<Integer> obj3=new Displayer<>();
        obj3.setNum(34);
        obj3.display();

        // for double
        Displayer<Double> obj4=new Displayer<>();
        obj4.setNum(34.3);
        obj4.display();

            // object generic class => no type safety
        Displayer2 d2=new Displayer2();
        d2.setNum(34.3);
        d2.display();

        // college
        DisplayerCollege<College> obj5=new DisplayerCollege<>();
        obj5.setNum(new College());
        obj5.display();

        // Students
        DisplayerCollege<Student> obj6=new DisplayerCollege<>();
        obj6.setNum(new Student());
        obj6.display();

        // Teacher
        DisplayerCollege<Teacher> obj7=new DisplayerCollege<>();
        obj7.setNum(new Teacher());
        obj7.display();

        //
        Java_generics mg=new Java_generics();
        mg.heyGen("shankar");
    }
}

class IntegerDisplay{
    Integer num;

    public void setNum(Integer num){
        this.num=num;
    }
    
    public void display(){
        System.out.println("Element -> "+this.num);
    }
}

class DoubleDisplay{
    double num;

    public void setNum(double num){
        this.num=num;
    }
    
    public void display(){
        System.out.println("Element -> "+this.num);
    }
}

// generic class
class Displayer<T>{
    T num;

    public void setNum(T num){
        this.num=num;
    }
    
    public void display(){
        System.out.println("Element -> "+this.num);
    }
}

// generic class
class DisplayerCollege<T extends College>{
    T num;

    public void setNum(T num){
        this.num=num;
        this.num.printCollgeName();
    }
    
    public void display(){
        System.out.println("Element -> "+this.num);
    }
}

// generic Object class
class Displayer2{
    Object num;

    public void setNum(Object num){
        this.num=num;
    }
    
    public void display(){
        System.out.println("Element -> "+this.num);
    }
}

class Student extends College{
    void printName(){
        System.out.println("Student Name printed");
    }
}

class Teacher extends College{
    void printName(){
        System.out.println("Teacher Name printed");
    }
}

class College{
    void printCollgeName(){
        System.out.println("XYZ institute of technology");
    }
}