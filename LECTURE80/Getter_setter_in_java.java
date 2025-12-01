package JAVA.SHASHCODE.LECTURE80;

// getter() made to access "private data"
// setter() made to set "private data"

// read only class => Getter funtion only
// write only class => setter funtion only
// read & write only class => getter and setter funtion both created

// getter can be private but it getter basically used to access the private variables

class ReadOnly{
    private int age;
    private String name;

    ReadOnly(){
        this.age=36;
        this.name="E3";
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

}

class WriteOnly{
    private int age;
    private String name;
    public void setAge(int age){
        this.age=age;
    }

    public void setName(String name){
        this.name=name;
    }
}


class ReadWrite{
    private int age;
    private String name;

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void setName(String name){
        this.name=name;
    }
}
public class Getter_setter_in_java {
    public static void main(String[] args) {
        ReadWrite rw=new ReadWrite();
        rw.setAge(24);
        System.out.println(rw.getName());
        ReadOnly ro=new ReadOnly();
        System.out.println(ro.getName());
        WriteOnly wo=new WriteOnly();
        wo.setAge(36);
    }
}
