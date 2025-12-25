package JAVA.SHASHCODE.LECTURE91;

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}

public class Pairwise_swap_node_of_linked_list {
    public Node pairwiseSwap(Node head) {
        Node first=head;
        Node prev=null;
        while(first!=null && first.next!=null){
            Node second =first.next;

            first.next=second.next;
            second.next=first;
            // first swap/swapping head node
            if(prev==null){
                head=second;
            }
            else{
                prev.next=second;
            }
            prev=first;
            first=first.next;
        }
        return head;
    }
}
