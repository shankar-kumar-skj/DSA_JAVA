package JAVA.SHASHCODE.LECTURE71;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// priority Queue is based on heap data structure

public class Priority_Queue_collection {
    public static void main(String[] args) {

        // Queue<Integer> PriorityQ=new PriorityQueue<>(); => min heep 
        // Queue<Integer> PriorityQ=new PriorityQueue<>(Comparator.reverseOrder()); => max heep 

        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(7);
        
        Queue<Integer> PriorityQ=new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list); // sorting list using collections
        System.out.println();

        PriorityQ.offer(3); // O(N)
        PriorityQ.offer(4); // O(N)
        PriorityQ.offer(7); // O(N)
        PriorityQ.offer(8); // O(N)

        System.out.println(PriorityQ);
        System.out.println(PriorityQ.peek());// O(1)
        System.out.println(PriorityQ);
        System.out.println(PriorityQ.poll());// O(N)
        System.out.println(PriorityQ);
    }
}
