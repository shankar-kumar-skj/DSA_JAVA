package JAVA.SHASHCODE.LECTURE71;

import java.util.ArrayDeque;
import java.util.Deque;

// dequeue => double ended queue
// => Insertion and deletion both can be performed at either ends.

// => operations :-

// peek()
// peekFirst()
// peekList()

// poll()
// pollFirst()
// pollLast()

// offer()
// offerFirst()
// offerLast()

public class Deque_collection {
    public static void main(String[] args) {
        Deque<Integer> queue=new ArrayDeque<>();
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue);
        
        System.out.println(queue.offer(33));
        System.out.println(queue);
        System.out.println(queue.offerFirst(44));
        System.out.println(queue);
        System.out.println(queue.offerLast(55));
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.peekFirst());
        System.out.println(queue);
        System.out.println(queue.peekLast());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.pollFirst());
        System.out.println(queue);
        System.out.println(queue.pollLast());
        System.out.println(queue);
    }
}
