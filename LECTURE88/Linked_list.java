package JAVA.SHASHCODE.LECTURE88;

// node => data + address

class Node<T> {
    T data;
    Node next;

    Node() {
        this.next = null;
    }

    Node(T data) {
        this.next = null;
        this.data = data;
    }
}

public class Linked_list {
    public static void main(String[] args) {
        Linked_list obj = new Linked_list();
        obj.insertTail(32);
        obj.printList();
        obj.insertTail(12);
        obj.printList();
        obj.insertHead(2);
        obj.printList();
        obj.insertNode(40, 7);
        obj.printList();
        obj.insertNode(40, 4);
        obj.printList();
        obj.insertNode(90, 4);
        obj.printList();

        obj.deleteTail();
        obj.printList();
        obj.deletionHead();
        obj.printList();
        obj.deleteNode(5);
        obj.printList();
        obj.deleteNode(2);
        obj.printList();

        obj.updateNode(2, 44);
        obj.printList();
        obj.updateNode(6, 4);
        obj.printList();

        obj.searchNode(44);
        obj.searchNode(22);
    }

    Node<Integer> head;
    int size;

    Linked_list() {
        this.head = null;
        this.size = 0;
    }

    // INSERTION IN LINKEDLIST
    public void insertHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            System.out.println("Insertion on the head ");
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Insertion on the head ");
        size++;
    }

    // INSERTION IN LINKEDLIST
    public void insertTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            System.out.println("Insertion on the tail ");
            size++;
            return;
        }
        Node<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Insertion on the tail ");
        size++;
    }

    public void insertNode(int data, int position) {
        if (position > size + 1 || position <= 0) {
            System.out.println("Wrong input");
        }
        if (position == 1) {
            insertHead(data);
        } else if (position == size + 1) {
            insertTail(data);
        } else {
            int counter = 1;
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;
            while (counter < position - 1 && temp != null) {
                counter++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("Insertion is successfull at position: " + position);
    }

    public void printList() {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println("data is -> " + temp.data);
            temp = temp.next;

        }
    }

    // deletion in LInked List
    public void deletionHead() {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("deletion at head is successfull");
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            System.out.println("deletion at tail is successfull");
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("deletion at tail is successfull");
        size--;
    }

    public void deleteNode(int position) {
        if (position > size || position <= 0) {
            System.out.println("Wrong input");
        }
        if (position == 1) {
            deletionHead();
        } else if (position == size) {
            deleteTail();
        } else {
            int counter = 1;
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while (counter < position && temp != null) {
                counter++;
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            size--;
            System.out.println("deletion is successfull at position: " + position);
        }
    }

    // UPDATE
    public void updateNode(int position, int updatedValue) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (counter < position && temp != null) {
            counter++;
            temp = temp.next;
        }
        if (temp != null && counter == position) {
            temp.data = updatedValue;
        } else {
            System.out.println("Size of linked list is smaller than position " + position);
            return;
        }
        System.out.println("Update at position " + position + " was successfull");
    }

    // search
    public boolean searchNode(int searchValue) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return false;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (temp != null) {
            if (temp.data == searchValue) {
                System.out.println("Found at position " + counter + " was successfull");
                return true;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Not Found");
        return false;
    }
}
