package JAVA.SHASHCODE.LECTURE71;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// arraylist non-synchronized
// arraylist n/2+1 increase capacity
// arraylist failed in multi thread environment

public class MyCollection {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        int x=10;
        list.add(x);
        // list.add("str"); so error because it is a int type
        
        List<String> list1=new ArrayList<>();
        // int x1="www";
        // list1.add(Integer.valueOf(x1));
        // list1.add(x1);
        System.out.println(list.size());

        List<int[]> list2=new ArrayList<>();
        int x2[]={2};
        list2.add(x2);
        System.out.println(list.size());

        // function of list

        // add()
        List<Integer> list3=new ArrayList<>();
        // capacity -> 10
        // size -> total number of element
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(3);
        System.out.println(list3);

        // remove()
        list3.remove(5); // index element remove

        list3.remove(Integer.valueOf(5)); // find element and then delete that
        System.out.println(list3);

        // contains
        System.out.println(list3.contains(4));

        // get()
        System.out.println(list3.get(2));

        // set (index number, value to insert on that index)
        System.out.println(list3.set(2,3));
        System.out.println(list3);
        
        // TO FIND TOTAL NUMBER OF ELEMENT
        System.out.println("size:"+list3.size());


        // iterator -> hasnext() --> move only front
        Iterator<Integer> itr=list3.iterator();
        System.out.println("MY LIST ----> ");
        while(itr.hasNext()){
            System.out.print(itr.next());
        }

        // ArrayList class -> increase its capacity with n + (n/2 + 1) formula.


        // list iterator --> moves previous and next both direction
        ListIterator<Integer> itr1=list3.listIterator();
        System.out.println("MY LIST ----> ");
        while(itr1.hasNext()){
            System.out.print(itr1.next());
        }
        System.out.println("MY LIST ----> ");
        while(itr1.hasNext()){
            System.out.print(itr1.next());
            if(itr1.hasPrevious()){
                System.out.print(itr1.previous());
                break;
            }
        }

        // sorting ?
        list3.sort(new Comparator<Integer>() {
            // negative A-B
            // positive B-A
            public int compare(Integer A, Integer B){
                return A-B;
            }
        });
        System.out.println("SORTED ARRAY : "+list3);

        List<Student> list4=new ArrayList<>();
        list4.add(new Student(10, "shankar"));
        list4.add(new Student(11, "pulkit"));
        list4.add(new Student(12, "sahil"));
        list4.add(new Student(13, "divyansh"));

        System.out.print(list4);
        list4.sort(new Comparator<Student>() {
            public int compare(Student A,Student B ){
                int res=B.rollNumber-A.rollNumber;
                if(res==0){
                    // according to alphate a -> z if roll number is same
                    return A.name.compareTo(B.name); 
                }
                return res;
            }
        });
        System.out.println("SORTED ARRAY ACCORDING TO ROLL NO. : : "+list4);
    }
}

class Student{
    int rollNumber; // this.rollNumber
    String name; // this.name
    public Student(int rollNumber,String name){
        this.rollNumber=rollNumber;
        this.name=name;
    }

    public String toString(){
        return name;
    }
}
