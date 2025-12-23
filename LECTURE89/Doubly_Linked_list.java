package JAVA.SHASHCODE.LECTURE89;

class DoublyNode<T> {
T data;
DoublyNode next;
DoublyNode prev;

DoublyNode() {
    this.next = null;
    this.prev=null;
}

DoublyNode(T data) {
    this.next = null;
    this.data = data;
    this.prev =null;
}
}
public class Doubly_Linked_list {
    public static void main(String[] args) {
        Doubly_Linked_list obj = new Doubly_Linked_list();
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
        System.out.println("-------------------------------");
        System.out.println("Print List In Reverse");
        obj.printListInReverse();

        obj.deleteTail();
        obj.printList();
        obj.deletionHead();
        obj.printList();
        obj.deleteNode(5);
        obj.printList();
        obj.deleteNode(2);
        obj.printList(); 
        System.out.println("-------------------------------");
        System.out.println("Print List In Reverse");
        obj.printListInReverse();

        obj.updateNode(2, 44);
        obj.printList();
        obj.updateNode(6, 4);
        obj.printList();

        obj.searchNode(44);
        obj.searchNode(22);
    }

    DoublyNode<Integer> head;
    DoublyNode<Integer> tail;
    int size;

    Doubly_Linked_list() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // INSERTION IN LINKEDLIST
    public void insertHead(int data) {
        DoublyNode<Integer> newNode = new DoublyNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("Insertion on the head ");
            size++;
            return;
        }
        newNode.next = head;
        head.prev=newNode;
        head = newNode;
        System.out.println("Insertion on the head ");
        size++;
    }

    // INSERTION IN LINKEDLIST
    public void insertTail(int data) {
        DoublyNode<Integer> newNode = new DoublyNode<>(data);
        if (head == null) {
            head = newNode;
            tail=newNode;

            System.out.println("Insertion on the tail ");
            size++;
            return;
        }
        DoublyNode<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev=temp;
        tail=newNode;
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
            DoublyNode<Integer> newNode = new DoublyNode<>(data);
            DoublyNode<Integer> temp = head;
            while (counter < position - 1 && temp != null) {
                counter++;
                temp = temp.next;
            }
            DoublyNode<Integer> currentNode=temp.next; 
            newNode.next=currentNode;
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.prev=temp;
            size++;
        }
        System.out.println("Insertion is successfull at position: " + position);
    }

    // print list
    public void printList() {
        DoublyNode<Integer> temp = head;
        while (temp != null) {
            System.out.println("data is -> " + temp.data);
            temp = temp.next;

        }
    }

    // print list in reverse
    public void printListInReverse() {
        DoublyNode<Integer> temp = tail;
        while (temp != null) {
            System.out.println("data is -> " + temp.data);
            temp = temp.prev;

        }
    }

    // deletion in LInked List
    public void deletionHead() {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        DoublyNode<Integer> temp = head;
        head = head.next;
        temp.next = null;
        if(head==null){
            tail=null;
        }
        else{
            head.prev=null;
        }
        
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
            tail=null;
            size--;
            System.out.println("deletion at tail is successfull");
            return;
        }
        DoublyNode<Integer> temp = head;
        DoublyNode<Integer> prevNode = null;
        while (temp.next != null) {
            prevNode = temp;
            temp = temp.next;
        }
        prevNode.next = null;
        temp.prev=null;
        tail=prevNode;
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
            DoublyNode<Integer> prevNode = null;
            DoublyNode<Integer> temp = head;
            while (counter < position && temp != null) {
                counter++;
                prevNode = temp;
                temp = temp.next;
            }
            DoublyNode<Integer> nextNode=temp.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            temp.prev=null;
            temp.next=null;

            prevNode.next = temp.next;
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
    DoublyNode<Integer> temp = head;

    while (counter < position && temp != null) {
        temp = temp.next;
        counter++;
    }

    if (temp != null) {
        temp.data = updatedValue;
        System.out.println("Update at position " + position + " was successful");
    } else {
        System.out.println("Size of linked list is smaller than position " + position);
    }
}


    // search
    public boolean searchNode(int searchValue) {
    if (head == null) {
        System.out.println("Linked List is empty");
        return false;
    }

    int counter = 1;
    DoublyNode<Integer> temp = head;

    while (temp != null) {
        if (temp.data.equals(searchValue)) {
            System.out.println("Found at position " + counter);
            return true;
        }
        temp = temp.next;
        counter++;
    }

    System.out.println("Not Found");
    return false;
}

}
