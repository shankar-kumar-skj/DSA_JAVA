package JAVA.SHASHCODE.LECTURE192;

// Red Black Tree => colour + Rotation => Tree Map creation 

// TreeMap => log(n)
// HashMap => log(n)

// TrreMap => always insert in sorted order by key

// Hashing => equals(),hashcode
// comparable => compareTo()
// comparator => compare()
import java.util.*;

class Student implements Comparable<Student>{
    int rollNo;
    int marks;
    String name;
    Student(int rollNo,int marks,String name){
        this.marks=marks;
        this.rollNo=rollNo;
        this.name=name;
    }

    @Override
    public int compareTo(Student that) {
        // sort inc roll
        // return this.rollNo-that.rollNo; // inc

        if(that.marks == this.marks){
            if(this.rollNo==that.rollNo){
                return this.name.compareTo(that.name); // lexographical order sort in name
            }
            return this.rollNo-that.rollNo; // inc
        }

        // sort inc roll
        return that.marks - this.marks; //dec
    }
    public String toString(){
        return "Student: "+ this.name;
    }
}

public class Treemap_collection {
    public static void main(String[] args) {
        TreeMap <Integer,Integer> tmap=new TreeMap<>();
        tmap.put(1,10);
        tmap.put(2,32);
        tmap.put(3,43);
        tmap.put(4,12);
        System.out.println(tmap.get(5));
        System.out.println(tmap.getOrDefault(5,0)); // FOR FIND FREQUENCEY
        
        for(Map.Entry<Integer,Integer> entry : tmap.entrySet()){
            System.out.print("Key -> "+entry.getKey());
            System.out.println(" ,Value -> "+entry.getValue());
        }

        // in reverse order by key 
        TreeMap <Integer,Integer> reverseTmap=new TreeMap<>(Collections.reverseOrder());
        reverseTmap.put(1,10);
        reverseTmap.put(2,32);
        reverseTmap.put(3,43);
        reverseTmap.put(4,12);
        System.out.println(reverseTmap.get(5));
        System.out.println(reverseTmap.getOrDefault(5,0)); // FOR FIND FREQUENCEY
        
        for(Map.Entry<Integer,Integer> entry : reverseTmap.entrySet()){
            System.out.print("Key -> "+entry.getKey());
            System.out.println(" ,Value -> "+entry.getValue());
        }


        // in Student tree map 
        TreeMap <Student,Integer> studentTmap=new TreeMap<>(Collections.reverseOrder());
        studentTmap.put(new Student(4,80,"madam ji"),10);
        studentTmap.put(new Student(7,88,"E3"),10);
        studentTmap.put(new Student(3,90,"SORRY"),10);
        
        Student obj=new Student(1,88,"Pain");
        System.out.print(studentTmap.containsKey(obj));



        // New Topic
        TreeMap <Integer,Integer> newTmap=new TreeMap<>();
        newTmap.put(1,10);
        newTmap.put(2,32);
        newTmap.put(3,43);
        newTmap.put(5,12);
        System.out.println(newTmap.containsKey(4));
        System.out.println(newTmap.containsKey(4)); // non available value => false(output)
        System.out.println(newTmap.ceilingKey(4)); // output => 5
        System.out.println(newTmap.floorKey(4)); // output => 3

        System.out.print(newTmap.lastKey()); // maximum value

        System.out.print(newTmap.firstKey()); // minimum value

    }
}
