package JAVA.SHASHCODE.LECTURE94;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Linked_List_Cycle {
    public ListNode firstNodeOfCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        boolean found=false;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;
            if(slow == fast){
                found= true;
                break;
            }
        }
        if(!found){
            return null;
        }
        slow =head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        ListNode startNode=firstNodeOfCycle(head);
        if(startNode!=null)
        System.out.println("Found starting Node -> "+ startNode.val);
        return false;
    }
}
