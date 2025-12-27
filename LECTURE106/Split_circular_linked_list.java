package JAVA.SHASHCODE.LECTURE106;

import javafx.util.Pair;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Split_circular_linked_list {
    // void splitList(circular_LinkedList list){
    //     Node head=list.head;
    //     Node head1=null;
    //     Node head2=null;

    //     Node slow =head;
    //     Node fast=head;
    //     while(fast.next!=head && fast.next.next!=head){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }

    //     head2=slow.next;
    //     head1=head;
    //     slow.next=head1;
    //     if(fast.next==head){
    //         fast.next=head2;
    //     }
    //     else{
    //         fast.next.next=head2;
    //     }

    //     list.head1=head1;
    //     list.head2=head2;

    // }


    public Pair<Node, Node> splitList(Node head) {
        // If list is empty
        if (head == null) {
            return new Pair<>(null, null);
        }

        Node slow = head;
        Node fast = head;

        // Find middle using slow and fast pointers
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For even number of nodes, move fast one step ahead
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // Set the heads of the two halves
        Node head1 = head;
        Node head2 = slow.next;

        // Make first half circular
        slow.next = head1;

        // Make second half circular
        fast.next = head2;

        return new Pair<>(head1, head2);
    }
}
