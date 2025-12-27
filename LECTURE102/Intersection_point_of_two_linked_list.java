package JAVA.SHASHCODE.LECTURE102;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Intersection_point_of_two_linked_list {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        while(t1!=t2){
            t1=(t1==null)?headB:t1.next;
            t2=(t2==null)?headA:t2.next;  
        }
        return t1;
    }
}
