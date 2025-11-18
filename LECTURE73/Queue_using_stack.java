package JAVA.SHASHCODE.LECTURE73;

// import java.util.LinkedList;
// import java.util.Queue;
import java.util.Stack;


public class Queue_using_stack {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();

    public void enqueue(int val){
        stack1.push(val);
    }

    public void enqueue_2nd_Method(int val){
        // move all item from stack 1 to satck 2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        // insert value in stack 2 to stack 1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int dequeue(){
        if(stack1.isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int dequeue_2nd_Method(){
        if(stack1.isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        int val=stack2.pop();
        return val;
    }
    public int peek(){
        if(stack1.isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val=stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int peek_2nd_Method(){
        if(stack1.isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        int val=stack2.peek();
        return val;
    }

    public static void main(String[] args) {
        // Queue<Integer> queue =new LinkedList<>();
        Queue_using_stack queue=new Queue_using_stack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("pop is : "+queue.dequeue());
        queue.enqueue(5);
        System.out.println("Peek is : "+queue.peek());
        queue.enqueue(6);
        System.out.println("Peek is : "+queue.dequeue());
        System.out.println("Peek is : "+queue.peek());
    }
}
