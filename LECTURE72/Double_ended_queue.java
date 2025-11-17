package JAVA.SHASHCODE.LECTURE72;

// insert or delete element from both side in double ended queue
// insertion => 
//       1. enqueue at the rear => offer last (i.e. => 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6) => 0 -> (capacity - 1)
//       2. enqueue at the front => offer first (i.e => 0 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1) => (capacity - 1) -> 0

// deletion => 
//       1. dequeue at the rear => poll last (i.e. => left move --) => 0 -> (capacity - 1)
//       2. dequeue at the front => poll first (i.e => Right move ++ ) => (capacity - 1) -> 0


public class Double_ended_queue {
    int rear;
    int front;
    int size;
    int capacity;
    int deque[];

    public Double_ended_queue(int capacity) {
        deque = new int[capacity];
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

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return -1;
        }
        return deque[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return -1;
        }
        return deque[rear];
    }

    public void enqueueRear(int val) {
        if (isFull()) {
            System.out.println("deque is full");
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
        deque[rear] = val;
    }

    public void enqueueFront(int val) {
        if (isFull()) {
            System.out.println("deque is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        // circular insertion
        else if (front == 0 && rear!= capacity-1) {
            front =capacity-1;
        }
        // normal case
        else {

            front--;
        }
        size++;
        deque[front] = val;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return -1;
        }
        int val = deque[front];
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

    public int dequeueRear() {
        if (isEmpty()) {
            System.out.println("deque is empty");
            return -1;
        }
        int val = deque[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        // circular deletion
        else if (rear == 0) {
            rear = capacity-1;
        }
        // normal
        else {
            rear--;
        }
        size--;
        return val;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("deque is Empty");
            return;
        }

        // circular case
        if (rear <= front) {
            for (int i = front; i <= capacity - 1; i++) {
                System.out.print(deque[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(deque[i]);
                if (i != rear) {
                    System.out.print(",");
                }
            }
        }

        // normal case
        else {
            for (int i = front; i <= rear; i++) {
                System.out.print(deque[i]);
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
        Double_ended_queue myCircularQueue = new Double_ended_queue(5);
        System.out.println("Capacity is : " + 5);
        System.out.println("Print : ");
        myCircularQueue.printQueue();
        System.out.println("Insert element : " + 7);
        myCircularQueue.enqueueFront(7);
        System.out.print("Peek element : " + myCircularQueue.peekRear());
        System.out.print("Insert element : " + 8);
        myCircularQueue.enqueueRear(8);
        System.out.println("Peak Element : " + myCircularQueue.peekRear());
        System.out.print("Insert element : " + 9);
        myCircularQueue.enqueueFront(9);
        System.out.println("Peek element : " + myCircularQueue.peekFront());
        System.out.print("Insert element : " + 11);
        myCircularQueue.enqueueFront(11);
        System.out.println("Peek element : " + myCircularQueue.peekRear());
        System.out.print("Insert element : " + 19);
        myCircularQueue.enqueueRear(19);
        System.out.println("Peek element : " + myCircularQueue.peekFront());
        System.out.print("Insert element : " + 9);
        myCircularQueue.enqueueFront(9);
        myCircularQueue.printQueue();

        // DRAWBACKS OF deque
        // => SIZE WASTE SO WE USE CIRCULAR deque
    }
}
