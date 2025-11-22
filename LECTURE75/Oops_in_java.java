package JAVA.SHASHCODE.LECTURE75;

// class -> no memory used
// obj -> used memory => heap memmory

class Car {
    String brand;
    String color;
    String model;
    boolean isABPresent;
    int speed;

    // constructor
    Car(){
        System.out.println("This is Default");
        this.brand = "Rolls Royce";
        this.color = "Black";
        this.model = "Phantam";
        this.isABPresent = true;
        this.speed = 100;
    }
    Car(String brand, String color, String model, boolean isABPresent, int speed) {
        System.out.println("Init");
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.isABPresent = isABPresent;
        this.speed = speed;
        System.out.println("Init done!");
    }

    Car(Car newCar){
        this.brand = newCar.brand;
        this.color = newCar.color;
        this.model = newCar.model;
        this.isABPresent = newCar.isABPresent;
        this.speed = newCar.speed;
        System.out.println("Copy Constructor!");
    }

    public void Drive() {
        System.out.println("Driving");
    }
    public void Drive(int speed) {

        System.out.println("Driving");
    }

    public void SpeedUp(int newSpeed) {
        speed = newSpeed;
        System.out.println("Speed Up : " + speed);
    }
}

public class Oops_in_java {
    public static void main(String[] args) {
        // Car object; // no memory allocation
        // default constructor
        Car object=new Car(); // object is allocation in heap memory
        // int arr[]=new int[56];

        // parameterized constructor
        System.out.println("speed : "+ object.speed);
        Car object1=new Car("rolls royce","black","Phantam",true,80);
        
        // copy constructor (copy property of one object to another)
        Car object3=new Car(object1);
        System.out.println("speed : "+object3.speed);

        // value copy only --> deep copy
        object1.speed=200;
        System.out.println("speed : "+object1.speed); // 200
        System.out.println("speed : "+object3.speed); // 80
        
        // refrence copy --> swallow copy
        Car object4=object1;
        System.out.println("speed 4 : "+object4.speed);
        object1.speed=200;
        System.out.println("speed 2 : "+object1.speed); // 200
        System.out.println("speed 4 : "+object4.speed); // 200

        

        
    }

}
