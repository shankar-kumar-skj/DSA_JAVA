package JAVA.SHASHCODE.LECTURE72;

//  circular queue is also know as rain buffer

public class Circle_queue {
    int rear;
    int front;
    int size;
    int capacity;
    int circleQueue[];

    public Circle_queue(int capacity) {
        circleQueue = new int[capacity];
        this.capacity = capacity;
        size = 0;
        rear = front = -1;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((front == 0 && rear == capacity - 1) || (front != 0 && rear == (front - 1) % (capacity))) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("circleQueue is empty");
            return -1;
        }
        return circleQueue[front];
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("circleQueue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        // circular insertion
        else if (rear == capacity - 1 && front != 0) {
            rear = 0;
        }
        // normal case
        else {

            rear++;
        }
        size++;
        circleQueue[rear] = val;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("circleQueue is empty");
            return -1;
        }
        int val = circleQueue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // circular deletion
        else if (front == capacity - 1) {
            front = 0;
        }
        // normal
        else {
            front++;
        }
        size--;
        return val;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("circleQueue is Empty");
            return;
        }

        // circular case
        if (rear <= front) {
            for (int i = front; i <= capacity - 1; i++) {
                System.out.print(circleQueue[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(circleQueue[i]);
                if (i != rear) {
                    System.out.print(",");
                }
            }
        }

        // normal case
        else {
            for (int i = front; i <= rear; i++) {
                System.out.print(circleQueue[i]);
                if (i != rear) {
                    System.out.print(",");
                }
            }
        }
        System.out.println();
    }

    public int Size() {
        return size;
    }

    public static void main(String[] args) {
        Circle_queue myCircularQueue = new Circle_queue(5);
        System.out.println("Capacity is : " + 5);
        System.out.println("Print : ");
        myCircularQueue.printQueue();
        System.out.println("Insert element : " + 7);
        myCircularQueue.enqueue(7);
        System.out.print("Peek element : " + myCircularQueue.peek());
        System.out.print("Insert element : " + 8);
        myCircularQueue.enqueue(8);
        System.out.println("Peak Element : " + myCircularQueue.peek());
        System.out.print("Insert element : " + 9);
        myCircularQueue.enqueue(9);
        System.out.println("Peek element : " + myCircularQueue.peek());
        System.out.print("Insert element : " + 11);
        myCircularQueue.enqueue(11);
        System.out.println("Peek element : " + myCircularQueue.peek());
        System.out.print("Insert element : " + 19);
        myCircularQueue.enqueue(19);
        System.out.println("Peek element : " + myCircularQueue.peek());
        System.out.print("Insert element : " + 9);
        myCircularQueue.enqueue(9);
        myCircularQueue.printQueue();

        // DRAWBACKS OF circleQueue
        // => SIZE WASTE SO WE USE CIRCULAR circleQueue
    }
}