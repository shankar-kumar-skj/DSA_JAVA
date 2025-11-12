package JAVA.SHASHCODE.LECTURE71;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

// => vector is basically syncronized 
// => it is not failed in multi thread environment
// vector 2n capacity increase

public class VectorList_collection {
   public static void main(String[] args) {
        List<Integer> list3=new Vector<>(); //DOUBLY LINKEDLIST

        list3.add(1);
        list3.add(3);
        list3.add(4);
        list3.add(6);
        list3.add(7,2);
        list3.add(1);
        System.out.println(list3);
        System.out.println(list3.size());
        list3.remove(2);
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

        List<Student> list4=new Vector<>();
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

