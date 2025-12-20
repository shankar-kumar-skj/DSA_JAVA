package JAVA.SHASHCODE.LECTURE87;

// class 
// (i)  Inheritance (IS A)
// (ii) Association (HAS A)
        // (a) Aggregation (loose-coupled)
        // (b) composition (tightly coupled)

public class Java_Association {
    public static void main(String[] args) {
        MyCar c=new MyCar();
        Driver d=new Driver(c);
        d.print();
    }
}

class MyCar{
    public void drive(){
        System.out.println("I am driving");
    }
    protected void drop(){
        System.out.println("Dropped");
    }
}

class Driver{
    // has a relationship
    MyCar object;
    Driver(MyCar object){
        this.object=object;
    }
    void print(){
        object.drive();
        object.drop();
    }
}
