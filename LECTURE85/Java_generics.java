package JAVA.SHASHCODE.LECTURE85;

public class Java_generics {
    public static void main(String[] args) {
        IntegerDisplay obj=new IntegerDisplay();
    obj.setNum(20);
    obj.display();
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
