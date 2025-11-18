package JAVA.SHASHCODE.LECTURE74;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_using_Queue {
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public void push(int val){
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        queue1.offer(val);
        while(!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
    }

    public int peek(){
        if(queue1.isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return queue1.peek();
    }

    public int pop(){
        if(queue1.isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return queue1.poll();
    }

    public static void main(String[] args) {
        Stack_using_Queue stack=new Stack_using_Queue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("STACK POP : "+ stack.pop());
        stack.push(5);
        System.out.println("STACK Peek : "+ stack.peek());
        stack.push(6);
        stack.push(7);
        System.out.println("STACK POP : "+ stack.pop());
        System.out.println("STACK Peek : "+ stack.peek());
    }
}
