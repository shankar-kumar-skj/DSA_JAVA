package JAVA.SHASHCODE.LECTURE71;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_collection {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

    }
}
