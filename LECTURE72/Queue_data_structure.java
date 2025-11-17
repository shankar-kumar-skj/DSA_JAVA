package JAVA.SHASHCODE.LECTURE72;

// import java.util.*;

// Queue => first come first serve
// queue is in 2 part :-
// rear => insertion / enque => offer
// front => Delete / dequeue => poll

// Implemantion Queue Data Structure
// using Array
// using LinkList
// using Stack

public class Queue_data_structure {
    int rear;
    int front;
    int size;
    int capacity;
    int queue[];
    public Queue_data_structure(int capacity){
        queue=new int[capacity];
        this.capacity=capacity;
        size=0;
        rear=front=-1;
    }
    public boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(rear==capacity-1){
            return true;
        }
        return false;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
    
    public void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty()){
            front=0;
            rear=0;
        }
        else{
            rear++;
        }
        size++;
        queue[rear]=val;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int val=queue[front];
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front++;
        }
        size--;
        return val;
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return ;
        }
        for(int i=front;i<=rear;i++){
            System.out.print(queue[i]);
            if(i!=rear){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public int Size(){
        return size;
    }
    public static void main(String[] args) {
        Queue_data_structure myQueue=new Queue_data_structure(5);
        System.out.println("Capacity is : "+5);
        System.out.println("Print : ");
        myQueue.printQueue();
        System.out.println("Insert element : "+7);
        myQueue.enqueue(7);
        System.out.print("Peek element : "+myQueue.peek());
        System.out.print("Insert element : "+8);
        myQueue.enqueue(8);
        System.out.println("Peak Element : "+myQueue.peek());
        System.out.print("Insert element : "+9);
        myQueue.enqueue(9);
        System.out.println("Peek element : "+ myQueue.peek());
        System.out.print("Insert element : "+11);
        myQueue.enqueue(11);
        System.out.println("Peek element : "+ myQueue.peek());
        System.out.print("Insert element : "+19);
        myQueue.enqueue(19);
        System.out.println("Peek element : "+ myQueue.peek());
        System.out.print("Insert element : "+9);
        myQueue.enqueue(9);
        myQueue.printQueue();


        // DRAWBACKS OF QUEUE
        // => SIZE WASTE SO WE USE CIRCULAR QUEUE
    }
}
