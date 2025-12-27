package JAVA.SHASHCODE.LECTURE103;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Insert_in_a_sorted_list {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node newNode =new Node(key);
        Node prev=null;
        Node temp=head1;
        while(temp!=null){
            if(temp.data>=key){
               break; 
            }
            prev=temp;
            temp=temp.next;
        }
        if(prev==null){
            newNode.next=head1;
            head1=newNode;
        }
        else{
            newNode.next=prev.next;
            prev.next=newNode;
        }
        return head1;
    }
}
