package JAVA.SHASHCODE.LECTURE194;
import java.util.*;

// Time Complexity :-
// => log2(N)

// When used ?
//  => group of element insert and remove at same time.

// Priority Queue
// =>  A data structure where elements are retrieved based upon priority.(Maps are used to implement Priority Queue)

// => There are group of elements stored, return the one which as highest priority.

// Priority Queue
// 1.) Min Priority Queue (min - heap) [increasing order]
// 2.) Max Priority Queue (Max - heap) [decreasing order]

// Priority can be the element itself or a property related to the element.
// For Example -> (Element is Priority)
// 1.) A) given 10 numbers, find the smallest & 2nd smallest element.
//     B) insert 5 more numbers, now return smallest.
// 2.) Property of element is priority
//     => In a class, there are 20 students, return the name of the student who got the highest marks.
//     => If there are multiple toppers, return the one whose name is lexicographically order smaller.

class NewStudent implements Comparable<NewStudent>{
    int marks;
    String name;
    NewStudent(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
    @Override
    public String toString() {
        return "Student name : "+this.name+" , marks : "+marks;
    }

    // this.p1(madam ji),that.p2 (shankar sir)
    @Override
    public int compareTo(NewStudent that) {
        // return this.marks-that.marks; // increasing - ascending order
        if(that.marks==this.marks){
            return this.name.compareTo(that.name); // -neg, 0, pos
        }
        return that.marks-this.marks; // Decreasing - decreasing order
    }

    // object compair using equal method
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NewStudent){
            NewStudent that=(NewStudent) obj;
            boolean isNameSame=(this.name.compareTo(that.name))==0;
            if(this.marks==that.marks && isNameSame){
                return true;
            }
            return false;
        }
            return false;
    }
}
public class Priority_queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        System.out.print("Highest Priority element -> "+pq.peek());

        // default Priority Queue => Min Priority Queue 
        PriorityQueue<Integer> Minpq= new PriorityQueue<>();
        Minpq.offer(1);
        Minpq.offer(2);
        Minpq.offer(3);
        Minpq.offer(4);
        System.out.print("Highest Priority element -> "+Minpq.peek());

        // Max Priority Queue :-

        PriorityQueue<Integer> Maxpq= new PriorityQueue<>(Collections.reverseOrder());
        Maxpq.offer(1);
        Maxpq.offer(2);
        Maxpq.offer(3);
        Maxpq.offer(4);
        System.out.print("MAX PRIORITY QUEUE");
        System.out.print("Highest Priority element -> "+Maxpq.peek());
        System.out.print(Maxpq.contains(10));
        System.out.print("delete element -> "+Maxpq.poll());
        System.out.print("Highest Priority element -> "+Maxpq.peek());
        System.out.print(Maxpq.contains(10));

        PriorityQueue<NewStudent> minStudentPq=new PriorityQueue<>();
        NewStudent ns=new NewStudent("Shankar Sir", 78);
        minStudentPq.offer(new NewStudent("MADAM Ji", 98));
        minStudentPq.offer(new NewStudent("Srishti Ji", 88));
        minStudentPq.offer(ns);
        System.out.print(minStudentPq.peek());

        System.out.println(minStudentPq.contains(ns));

        
    }
}
