package JAVA.SHASHCODE.LECTURE93;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Reverse_linked_list {
    
    public ListNode reverseList(ListNode head) {
    // // iterate approach
        // ListNode current =head;
        // ListNode prev=null;
        // while(current!=null){
        //     ListNode nextNode=current.next;
        //     current.next=prev;
        //     prev=current;
        //     current =nextNode;
        // }
        // return prev;
        
            // recursive approach
        if(head==null || head.next==null){
            return head;
        }
        // recursive call
        ListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
